package com.mbg.otdev.esDemo.controller;

import com.mbg.otdev.esDemo.config.config;
import com.mbg.otdev.esDemo.dao.FaceRepository;
import com.mbg.otdev.esDemo.model.Face;
import com.mbg.otdev.esDemo.model.FaceMerge;
import com.mbg.otdev.esDemo.model.FacefileReq;
import com.mbg.otdev.esDemo.service.FaceService;
import com.mbg.otdev.esDemo.service.GreetingService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.io.FilenameUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FaceController {

    @Autowired
    private FaceService faceService;

    @Autowired
    private FaceRepository repository;

    @Autowired
    private config cfg;

    @Autowired
    ElasticsearchTemplate template;


    @ResponseBody
    @RequestMapping(value = "/faceraw", method = RequestMethod.GET)
    public ResponseEntity<List<Face>> getAll() {
        return new ResponseEntity<List<Face>>(faceService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/faceraw", method = RequestMethod.POST)
    public ResponseEntity<Face> insertFaceraw(@RequestBody Face face) {

        //template.createIndex("myindex3");
        //template.putMapping(Greeting.class);
        //template.refresh("myindex3");
        //template.refresh(Greeting.class);

//        cfg.setSaveIndexName("abindex1");
//        System.out.println(cfg.getSaveIndexName());

        //return null;
        return new ResponseEntity<Face>(faceService.create(face), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/face-raw-file", method = RequestMethod.POST)
    public String insertFacerawFromFile(@RequestBody FacefileReq facefilereq) {

        //System.out.println(facefilereq.getFilePath()+","+facefilereq.getFileName()+","+facefilereq.getJobId());
        String filefulpath = facefilereq.getFilePath()+"/"+facefilereq.getFileName();

        int pos = facefilereq.getFileName() .lastIndexOf(".");
        String fileName = facefilereq.getFileName().substring(0, pos);
        System.out.println(fileName);

        ArrayList<Face> faceList = null;
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(filefulpath));

            faceList = new ArrayList<Face>();
            //CSVReader csvReader = new CSVReader(br);
            CSVReader csvReader = new CSVReaderBuilder(br).withSkipLines(1).build();


            String[] line;
            while ((line = csvReader.readNext()) != null) {
                //pirintline(line);

                Face face = new Face();
                face.setFaceid( Integer.parseInt(line[0].trim() ));
                face.setVideoid( Integer.parseInt(line[14].trim() ));
                face.setFrameindex(Integer.parseInt(line[18].trim() ));
                face.setScore( Float.parseFloat(line[19].trim() ));
                face.setActorid(Integer.parseInt(line[21].trim() ));
                face.setJobid(facefilereq.getJobId());

                String [] rect = line[20].trim().split(",");
                face.setRectx( Integer.parseInt(rect[0].trim() ));
                face.setRecty( Integer.parseInt(rect[1].trim() ));
                face.setRectw( Integer.parseInt(rect[2].trim() ));
                face.setRecth( Integer.parseInt(rect[3].trim() ));

                faceList.add(face);
            }

            br.close();
            csvReader.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(faceList.size());

        //String indexName = "mdp_"+fileName+"_raw_face";
        String indexName = "mdp_"+fileName;
        if ( !template.indexExists(indexName)) {
            template.createIndex(indexName);
        }

        cfg.setFaceindexName(indexName);

//        System.out.println("indexname="+cfg.getFaceindexName());
//        Face face = faceList.get(0);
//        System.out.println("faceid="+face.getFaceid());
//        faceService.create(face);

        ObjectMapper mapper = new ObjectMapper();
        List<IndexQuery> queries = new ArrayList<>();
        try {
            for(Face face : faceList) {
                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setId(Integer.toString(face.getFaceid()));
                indexQuery.setSource(mapper.writeValueAsString(face));
                indexQuery.setIndexName(indexName);
                indexQuery.setType("faceraw");
                queries.add(indexQuery);
            }

            if (queries.size() > 0) {
                template.bulkIndex(queries);
            }
            template.refresh(indexName);

        }catch(Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @RequestMapping(value = "/face-merge-file", method = RequestMethod.POST)
    public String insertFacemergeFromFile(@RequestBody FacefileReq facefilereq) {
        String filefulpath = facefilereq.getFilePath()+"/"+facefilereq.getFileName();

        int pos = facefilereq.getFileName() .lastIndexOf(".");
        String fileName = facefilereq.getFileName().substring(0, pos);
        System.out.println(fileName);

        ArrayList<FaceMerge> faceList = null;
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(filefulpath));

            faceList = new ArrayList<FaceMerge>();
            //CSVReader csvReader = new CSVReader(br);
            CSVReader csvReader = new CSVReaderBuilder(br).withSkipLines(1).build();


            String[] line;
            while ((line = csvReader.readNext()) != null) {
                pirintline(line);

                FaceMerge face = new FaceMerge();
                face.setMergefaceid(Integer.parseInt(line[0].trim() ));
                face.setVideoid(Integer.parseInt(line[1].trim() ));
                face.setActorid(Integer.parseInt(line[2].trim() ));
                face.setJobid(facefilereq.getJobId());

                SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss;SS");
                String from = line[3].trim();
                Date to = transFormat.parse(from);
                face.setStarttimecode(to);

                from = line[4].trim();
                to = transFormat.parse(from);
                face.setEndtimecode(to);

                face.setStartframeindex(Integer.parseInt(line[5].trim() ));
                face.setEndframeindex(Integer.parseInt(line[6].trim() ));

                SimpleDateFormat transFormatdate = new SimpleDateFormat("yyyyMMddHHmmss");
                from = line[11].trim();
                System.out.println("11->from="+from);
                to = transFormatdate.parse(from);
                face.setCreatetime(to);

                from = line[12].trim();
                System.out.println("12->from="+from);
                to = transFormatdate.parse(from);
                face.setModifytime(to);

                face.setKeyframeindex(Integer.parseInt(line[20].trim() ));

                faceList.add(face);
            }

            br.close();
            csvReader.close();
        }catch(Exception e) {
                e.printStackTrace();
        }

        System.out.println(faceList.size());

        //String indexName = "mdp_"+fileName+"_merge_face";
        String indexName = "mdp_"+fileName;
        if ( !template.indexExists(indexName)) {
            template.createIndex(indexName);
        }
        cfg.setFacemergeindexName(indexName);

        ObjectMapper mapper = new ObjectMapper();
        List<IndexQuery> queries = new ArrayList<>();
        try {
            for(FaceMerge face : faceList) {
                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setId(Integer.toString(face.getMergefaceid()));
                indexQuery.setSource(mapper.writeValueAsString(face));
                indexQuery.setIndexName(indexName);
                indexQuery.setType("facemerge");
                queries.add(indexQuery);
            }

            if (queries.size() > 0) {
                template.bulkIndex(queries);
            }
            template.refresh(indexName);

        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void pirintline(String[] line) {
        for(int i=0; i<line.length;i++) {
            System.out.print(line[i]+"|");
        }
        System.out.println("");
    }

}


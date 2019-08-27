package com.skt.mdp.FacePostExecutorSim.work;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.FaceRaw;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

public class faceRawWork implements Runnable {

    @Autowired
    ElasticsearchTemplate template;

    private FacefileReq facefilereq;
    private runConfig runcfg;
    private workManager workmanager = null;

    @Override
    public void run() {

        String filefulpath = facefilereq.getFilePath()+"/"+facefilereq.getFileName();
        int pos = facefilereq.getFileName() .lastIndexOf(".");
        String fileName = facefilereq.getFileName().substring(0, pos);
        System.out.println(fileName);

        ArrayList<FaceRaw> faceList = null;
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(filefulpath));

            faceList = new ArrayList<FaceRaw>();
            //CSVReader csvReader = new CSVReader(br);
            CSVReader csvReader = new CSVReaderBuilder(br).withSkipLines(1).build();

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                //pirintline(line);

                FaceRaw face = new FaceRaw();
                face.setFaceid( Integer.parseInt(line[0].trim() ));
                face.setVideoid( Integer.parseInt(line[14].trim() ));
                face.setFrameindex(Integer.parseInt(line[18].trim() ));
                face.setScore( Float.parseFloat(line[19].trim() ));
                face.setActorid(Integer.parseInt(line[21].trim() ));
                face.setJobid(facefilereq.getMdpJobId());

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

        runcfg.setFacerawindexName(indexName);

//        System.out.println("indexname="+cfg.getFaceindexName());
//        Face face = faceList.get(0);
//        System.out.println("faceid="+face.getFaceid());
//        faceService.create(face);

        ObjectMapper mapper = new ObjectMapper();
        List<IndexQuery> queries = new ArrayList<>();
        try {
            for(FaceRaw face : faceList) {
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

    }

    public runConfig getRuncfg() {
        return this.runcfg;
    }

    public void setRuncfg(runConfig runcfg) {
        this.runcfg = runcfg;
    }

    public FacefileReq getFacefilereq() {
        return this.facefilereq;
    }

    public void setFacefilereq(FacefileReq facefilereq) {
        this.facefilereq = facefilereq;
    }

    public workManager getWorkmanager() {
        return this.workmanager;
    }

    public void setWorkmanager(workManager workmanager) {
        this.workmanager = workmanager;
    }
}
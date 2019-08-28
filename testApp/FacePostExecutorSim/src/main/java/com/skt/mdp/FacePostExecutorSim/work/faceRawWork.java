package com.skt.mdp.FacePostExecutorSim.work;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.skt.mdp.FacePostExecutorSim.config.runConfig;
import com.skt.mdp.FacePostExecutorSim.model.FaceRaw;
import com.skt.mdp.FacePostExecutorSim.model.FacefileReq;

import com.skt.mdp.FacePostExecutorSim.repo.FaceRawRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class faceRawWork implements Runnable {
    public static final Logger log = LoggerFactory.getLogger(faceRawWork.class);

    private ElasticsearchTemplate template;
    private FacefileReq facefilereq;
    private runConfig runcfg;
    private workManager workmanager = null;

    @Override
    public void run() {
        log.info("faceRawWork start run");
        
        HashMap<String,String> reulstMap = new HashMap<String,String>();
        String jobstatus = "success";

        // String filefulpath = facefilereq.getReusltPath();
        // int pos = filefulpath.lastIndexOf(".");
        // String fileName = facefilereq.getFileName().substring(0, pos);
        String filefullpath = facefilereq.getReusltPath();
        System.out.println("1111111-"+filefullpath);
		int spos = filefullpath.lastIndexOf("/");
        String fileNameext = filefullpath.substring(spos+1, filefullpath.length());
        int pos = fileNameext.lastIndexOf(".");
        String fileName = fileNameext.substring(0, pos);
        System.out.println("2222222-"+fileName);

        log.info("faceRawWork start => "+filefullpath +"::"+fileName);

        ArrayList<FaceRaw> faceList = null;
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(filefullpath));

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
            jobstatus = "fail";
            e.printStackTrace();
        }

        log.info("faceList size="+faceList.size());

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
            System.out.println("queries.size="+queries.size());

            if (queries.size() > 0) {
                template.bulkIndex(queries);
            }
            template.refresh(indexName);

        }catch(Exception e) {
            jobstatus = "fail";
            e.printStackTrace();
        }

        log.info("face raw complete");
        for(int i=0; i<10; i++) {
            //System.out.println("i="+i);
            try {
                Thread.sleep(2000);
            }catch (Exception e) { }
       }

        if(workmanager != null) {
            reulstMap.put("jobstatus",jobstatus);
            //reulstMap.put("resultpath",resultpath);
            workmanager.setJobStauts(facefilereq.getMdpJobId(), reulstMap);
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

    public ElasticsearchTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ElasticsearchTemplate template) {
        this.template = template;
    }
}
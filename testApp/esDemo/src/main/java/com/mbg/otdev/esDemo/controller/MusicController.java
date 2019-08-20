package com.mbg.otdev.esDemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbg.otdev.esDemo.config.config;
import com.mbg.otdev.esDemo.dao.MusicRepository;
import com.mbg.otdev.esDemo.model.Music;
import com.mbg.otdev.esDemo.model.MusicMerge;
import com.mbg.otdev.esDemo.model.MusicfileReq;
import com.mbg.otdev.esDemo.service.MusicService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MusicController {

//    @Autowired
//    private MusicService musicService;
//
//    @Autowired
//    private MusicRepository repository;
//
//    @Autowired
//    private config cfg;
//
//    @Autowired
//    ElasticsearchTemplate template;
//
//
//    @ResponseBody
//    @RequestMapping(value = "/musicraw", method = RequestMethod.GET)
//    public ResponseEntity<List<Music>> getAll() {
//        return new ResponseEntity<List<Music>>(musicService.getAll(), HttpStatus.OK);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/musiceraw", method = RequestMethod.POST)
//    public ResponseEntity<Music> insertFaceraw(@RequestBody Music music) {
//
//        //template.createIndex("myindex3");
//        //template.putMapping(Greeting.class);
//        //template.refresh("myindex3");
//        //template.refresh(Greeting.class);
//
////        cfg.setSaveIndexName("abindex1");
////        System.out.println(cfg.getSaveIndexName());
//
//        //return null;
//        return new ResponseEntity<Music>(musicService.create(music), HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/music-raw-file", method = RequestMethod.POST)
//    public String insertFacerawFromFile(@RequestBody MusicfileReq musicfilereq) {
//
//        //System.out.println(facefilereq.getFilePath()+","+facefilereq.getFileName()+","+facefilereq.getJobId());
//        String filefulpath = musicfilereq.getFilePath()+"/"+musicfilereq.getFileName();
//
//        int pos = musicfilereq.getFileName() .lastIndexOf(".");
//        String fileName = musicfilereq.getFileName().substring(0, pos);
//        System.out.println(fileName);
//
//        ArrayList<Music> musicList = null;
//        BufferedReader br = null;
//        try{
//            br = Files.newBufferedReader(Paths.get(filefulpath));
//
//            musicList = new ArrayList<Music>();
//            //CSVReader csvReader = new CSVReader(br);
//            CSVReader csvReader = new CSVReaderBuilder(br).withSkipLines(1).build();
//
//            String[] line;
//            while ((line = csvReader.readNext()) != null) {
//                //pirintline(line);
//                Music music = new Music();
//                music.setMusicid(Integer.parseInt(line[0].trim() ));
//                music.setVideoid(Integer.parseInt(line[1].trim() ));
//                music.setJobid(musicfilereq.getJobId());
//
//                SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss;SS");
//                String from = line[2].trim();
//                Date to = transFormat.parse(from);
//                music.setStarttimecode(to);             //starttimecode
//
//                from = line[3].trim();
//                to = transFormat.parse(from);
//                music.setEndtimecode(to);             //endtimecode
//
//                music.setStartframeindex(Integer.parseInt(line[4].trim() ));    //startframeindex
//                music.setEndframeindex(Integer.parseInt(line[5].trim() ));    //endframeindex
//                music.setSequence(Integer.parseInt(line[6].trim() ));    //sequence
//
//                music.setAlbum_packagelanguage(line[7].trim());
//                music.setAlbum_titleofficial(line[8].trim());
//                music.setAlbum_year(line[9].trim());
//                music.setAlbum_genrelevel1(line[10].trim());
//                music.setAlbum_genrelevel2(line[11].trim());
//                music.setAlbum_genrelevel3(line[12].trim());
//                music.setAlbum_albumlabel(line[13].trim());
//                music.setAlbum_totalinset(Integer.parseInt(line[14].trim() ));
//                music.setAlbum_discinset(Integer.parseInt(line[15].trim() ));
//                music.setAlbum_trackcount(Integer.parseInt(line[16].trim() ));
//                music.setAlbum_coverarturl(line[17].trim());
//                music.setAlbum_track_trackgnid(line[18].trim());
//                music.setAlbum_track_tracknumber(Integer.parseInt(line[19].trim() ));
//                music.setAlbum_track_titleofficial(line[20].trim());
//
//                SimpleDateFormat transFormatdate = new SimpleDateFormat("yyyyMMddHHmmss");
//                from = line[21].trim();
//                to = transFormatdate.parse(from);
//                music.setCreatetime(to);
//
//                from = line[24].trim();
//                to = transFormatdate.parse(from);
//                music.setModifytime(to);
//
//                music.setAlbum_credit_nameofficial(line[32].trim());
//                music.setAlbum_credit_originlevel1(line[33].trim());
//                music.setAlbum_credit_originlevel2(line[34].trim());
//                music.setAlbum_credit_originlevel3(line[35].trim());
//                music.setAlbum_credit_originlevel4(line[36].trim());
//                music.setAlbum_credit_eralevel1(line[37].trim());
//                music.setAlbum_credit_eralevel2(line[38].trim());
//                music.setAlbum_credit_eralevel3(line[39].trim());
//                music.setAlbum_credit_artisttypelevel1(line[40].trim());
//                music.setAlbum_credit_artisttypelevel2(line[41].trim());
//
//                musicList.add(music);
//            }
//
//            br.close();
//            csvReader.close();
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(musicList.size());
//
//        String indexName = fileName+"_raw_music";
//        if ( !template.indexExists(indexName)) {
//            template.createIndex(indexName);
//        }
//        cfg.setFaceindexName(indexName);
//
//        System.out.println("indexname="+cfg.getFaceindexName());
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<IndexQuery> queries = new ArrayList<>();
//        try {
//            for(Music music : musicList) {
//                IndexQuery indexQuery = new IndexQuery();
//                indexQuery.setId(Integer.toString(music.getMusicid()));
//                indexQuery.setSource(mapper.writeValueAsString(music));
//                indexQuery.setIndexName(indexName);
//                indexQuery.setType("musicraw");
//                queries.add(indexQuery);
//            }
//
//            if (queries.size() > 0) {
//                template.bulkIndex(queries);
//            }
//            template.refresh(indexName);
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }
//
//    @RequestMapping(value = "/music-merge-file", method = RequestMethod.POST)
//    public String insertFacemergeFromFile(@RequestBody MusicfileReq musicfilereq) {
//        String filefulpath = musicfilereq.getFilePath()+"/"+musicfilereq.getFileName();
//
//        int pos = musicfilereq.getFileName() .lastIndexOf(".");
//        String fileName = musicfilereq.getFileName().substring(0, pos);
//        System.out.println(fileName);
//
//        ArrayList<MusicMerge> musicList = null;
//        BufferedReader br = null;
//        try {
//            System.out.println("filefulpath="+filefulpath);
//            //br = Files.newBufferedReader(Paths.get(filefulpath), StandardCharsets.UTF_8);
//            br = Files.newBufferedReader(Paths.get(filefulpath));
//
//            musicList = new ArrayList<MusicMerge>();
//
//            //CSVReader csvReader = new CSVReader(br);
//            CSVReader csvReader = new CSVReaderBuilder(br).withSkipLines(1).build();
//
//            String[] line;
//            while ((line = csvReader.readNext()) != null) {
//                //pirintline(line);
//                MusicMerge music = new MusicMerge();
//                music.setMusicid(Integer.parseInt(line[0].trim() ));
//                music.setVideoid(Integer.parseInt(line[1].trim() ));
//                music.setJobid(musicfilereq.getJobId());
//
//                SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss;SS");
//                String from = line[2].trim();
//                Date to = transFormat.parse(from);
//                music.setStarttimecode(to);             //starttimecode
//
//                from = line[3].trim();
//                to = transFormat.parse(from);
//                music.setEndtimecode(to);             //endtimecode
//
//                music.setStartframeindex(Integer.parseInt(line[4].trim() ));    //startframeindex
//                music.setEndframeindex(Integer.parseInt(line[5].trim() ));    //endframeindex
//                music.setSequence(Integer.parseInt(line[6].trim() ));    //sequence
//
//                music.setAlbum_packagelanguage(line[7].trim());
//                music.setAlbum_titleofficial(line[8].trim());
//                music.setAlbum_year(line[9].trim());
//                music.setAlbum_genrelevel1(line[10].trim());
//                music.setAlbum_genrelevel2(line[11].trim());
//                music.setAlbum_genrelevel3(line[12].trim());
//                music.setAlbum_albumlabel(line[13].trim());
//                music.setAlbum_totalinset(Integer.parseInt(line[14].trim() ));
//                music.setAlbum_discinset(Integer.parseInt(line[15].trim() ));
//                music.setAlbum_trackcount(Integer.parseInt(line[16].trim() ));
//                music.setAlbum_coverarturl(line[17].trim());
//                music.setAlbum_track_trackgnid(line[18].trim());
//                music.setAlbum_track_tracknumber(Integer.parseInt(line[19].trim() ));
//                music.setAlbum_track_titleofficial(line[20].trim());
//
//                SimpleDateFormat transFormatdate = new SimpleDateFormat("yyyyMMddHHmmss");
//                from = line[21].trim();
//                to = transFormatdate.parse(from);
//                music.setCreatetime(to);
//
//                from = line[24].trim();
//                to = transFormatdate.parse(from);
//                music.setModifytime(to);
//
//                music.setAlbum_credit_nameofficial(line[32].trim());
//                music.setAlbum_credit_originlevel1(line[33].trim());
//                music.setAlbum_credit_originlevel2(line[34].trim());
//                music.setAlbum_credit_originlevel3(line[35].trim());
//                music.setAlbum_credit_originlevel4(line[36].trim());
//                music.setAlbum_credit_eralevel1(line[37].trim());
//                music.setAlbum_credit_eralevel2(line[38].trim());
//                music.setAlbum_credit_eralevel3(line[39].trim());
//                music.setAlbum_credit_artisttypelevel1(line[40].trim());
//                music.setAlbum_credit_artisttypelevel2(line[41].trim());
//                music.setIsduplication(Integer.parseInt(line[42].trim() ));
//                musicList.add(music);
//            }
//
//            br.close();
//            csvReader.close();
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(musicList.size());
//
//        String indexName = fileName+"_merge_music";
//        if ( !template.indexExists(indexName)) {
//            template.createIndex(indexName);
//        }
//        cfg.setFacemergeindexName(indexName);
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<IndexQuery> queries = new ArrayList<>();
//        try {
//            for(MusicMerge music : musicList) {
//                IndexQuery indexQuery = new IndexQuery();
//                indexQuery.setId(Integer.toString(music.getMusicid()));
//                indexQuery.setSource(mapper.writeValueAsString(music));
//                indexQuery.setIndexName(indexName);
//                indexQuery.setType("musicmerge");
//                queries.add(indexQuery);
//            }
//
//            if (queries.size() > 0) {
//                template.bulkIndex(queries);
//            }
//            template.refresh(indexName);
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public void pirintline(String[] line) {
//        for(int i=0; i<line.length;i++) {
//            System.out.print(line[i]+"|");
//        }
//        System.out.println("");
//    }

}


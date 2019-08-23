#!/usr/bin/env python3
#-*- coding:utf-8 -*-
import requests, json

def createJob() :
    print ("start create job!!")
    #r = requests.get("http://localhost:7001/mdp/Enginecontrol/v1/face/deepwork?service_id=12345")
    #print (r.status_code)
    #print (r.text)

    crt_url = 'http://localhost:7001/mdp/Enginecontrol/v1/face/deepwork'
   
    req_str = '{"service_id" : "12345","episode_info": {"asis_cnts_id": "8492D8BA-5896-450C-B0AB-F6E19894746F","file_path_url": "/VOD/96/CS11009296/","play_tms_val": 10807,"rslu_file_nm": "CE1000147825_0_MOHD_201902202034ts","sris_id": "CS11009296","sris_nm": "EXO의 사다리타고 세계여행-가오슝/컨딩 편"},"epsd_id": "CE1000147825","meta_info": {"brcast_dt": "20190220000000","brcast_tseq_nm": "1","gnr_info": null,"manuf_country_nm": ["aaa"],"manuf_yr": "2016","manufco_nm": "SK broadand","meta_id": "MM1000144015","meta_title": "EXO의 사다리타고 세계여행-가오슝/컨딩 편","meta_typ_cd": "002","open_dy": "","people_info": [{"brth_ymd": "19900326","filmography": ["bbb"],"prs_id": "MP0000141243","prs_nm": "(EXO)","prs_role_cd": "10","sex_cd": "1","sort_seq": 3 }],"sub_title": "rrrrr","tot_tseq_ncnt": 0,"wat_lvl_cd": null}}'
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    #res = requests.post(crt_url, data=json.dumps(req_str), headers=headers)
    res = requests.post(crt_url, data=req_str, headers=headers)

    print (res.status_code)
    print (res.text)

def jobstatus() :
    status_url = "http://192.168.203.113:7001/mdp/Enginecontrol/v1/face/deepwork?service_id="+"12345"
    #status_url = "http://192.168.203.113:7001/mdp/Enginecontrol/v1/face/deepwork?service_id=12345"
    res = requests.get(status_url)
    print (res.status_code)
    print (res.text)

    json_data = json.loads(res.text)
    rslt_status = json_data["status"]

    print (rslt_status)


def main() :
    print ("start face demo!!")
    #createJob()
    jobstatus()

if __name__ == '__main__':
    main()
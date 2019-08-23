from datetime import datetime
import time
import requests, json

def main(**kwargs):
    print('run_face_raw_engine in ..........................')
    print (kwargs['dag_run'].conf)
    json_val = json.dumps(kwargs['dag_run'].conf, ensure_ascii=False)
    snd_val = json_val.encode('utf-8')

    crt_url = 'http://192.168.203.113:7005/mdp/Enginecontrol/v1/face/deepwork'

    headers = {'Content-type': 'application/json; charset=utf-8', 'Accept': 'application/json'}
    #res = requests.post(crt_url, data=json.dumps(json_val, ensure_ascii = False), headers=headers)
    res = requests.post(crt_url, data=snd_val, headers=headers)

    print (res.status_code)
    print (res.text)

    if res.status_code == 201 :
        print ("success code recevie !!")
        mdpJobId = kwargs['dag_run'].conf['mdpJobId']
        print ("mdp job id = %s",mdpJobId)
        status_url = "http://192.168.203.113:7005/mdp/Enginecontrol/v1/face/deepwork?mdpJobId="+mdpJobId

        while True :
            res = requests.get(status_url)
            if res.status_code == 200 :
                json_data = json.loads(res.text)
                rslt_status = json_data["status"]
                if rslt_status == "Process" :
                    print (rslt_status+" continue")
                    time.sleep(2)
                else :
                    print (rslt_status+" task shutdonw")
                    return json_data
                    #break
            else :
                raise ValueError('job status get fail') 

    else :
        print ("Fail code recevie !!")
        raise ValueError('job create fail')

from datetime import datetime
import time
import requests, json

def main(**kwargs):
    print('run_face_merge_engine in ..........................')
    ti = kwargs['ti']
    pulled_value_2 = ti.xcom_pull(task_ids='face_raw')
    print ("return value = %s",pulled_value_2)
    json_val = json.dumps(pulled_value_2, ensure_ascii=False)
    snd_val = json_val.encode('utf-8')

    

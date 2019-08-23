from datetime import datetime
import time
import requests, json

def main(**kwargs):
    print('run_face_raw_upload in ..........................')
    ti = kwargs['ti']
    pulled_value_2 = ti.xcom_pull(task_ids='face_raw')
    print ("return value = %s",pulled_value_2)

    

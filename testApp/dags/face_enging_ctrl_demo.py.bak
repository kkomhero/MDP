# -*- coding: utf-8 -*-

from airflow import DAG
from airflow.operators.bash_operator import BashOperator
from airflow.operators.python_operator import PythonOperator
from datetime import datetime, timedelta
import time
import requests, json

args = {
    'start_date': datetime.utcnow(),
    'owner': 'airflow',
}

dag = DAG(
    dag_id='face_engine_demo',
    default_args=args,
    schedule_interval=None,
)

def run_face_egine_func(ds, **kwargs):
	#print("Remotely received value of {} for key=message".
	#      format(kwargs['dag_run'].conf['message']))
	print (kwargs)
	json_val = json.dumps(kwargs['dag_run'].conf, ensure_ascii = False)
	print ("json_val = %s" % json_val)
	#snd_val = str(json_val,"utf-8")
	snd_val = json_val.encode('utf-8') 
	print ("snd_val = %s" % snd_val)

	crt_url = 'http://192.168.203.113:7001/mdp/Enginecontrol/v1/face/deepwork'

	headers = {'Content-type': 'application/json; charset=utf-8', 'Accept': 'application/json'}
	#res = requests.post(crt_url, data=json.dumps(json_val, ensure_ascii = False), headers=headers)
	res = requests.post(crt_url, data=snd_val, headers=headers)

	print (res.status_code)
	print (res.text)

	if res.status_code == 201 :
		print ("success code recevie !!")
		svc_id = kwargs['dag_run'].conf['service_id']
		print ("service id = %s",svc_id)
		status_url = "http://192.168.203.113:7001/mdp/Enginecontrol/v1/face/deepwork?service_id="+svc_id
		while True :
			res = requests.get(status_url)
			if res.status_code == 200 :
				json_data = json.loads(res.text)
				rslt_status = json_data["status"]
				if rslt_status == "Complete" :
					print (rslt_status+" task shutdonw")
					break
				else :
					print (rslt_status+" continue")
					time.sleep(2)
			else :
				raise ValueError('job status get fail') 
	else :
		print ("Fail code recevie !!")
		raise ValueError('job create fail') 



run_this = PythonOperator(
    task_id='run_face_egine',
    provide_context=True,
    python_callable=run_face_egine_func,
    dag=dag,
)


#task1 >> task2


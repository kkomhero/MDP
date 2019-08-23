# -*- coding: utf-8 -*-

from airflow import DAG
from airflow.operators.bash_operator import BashOperator
from airflow.operators.python_operator import PythonOperator
from datetime import datetime, timedelta
from run_face_raw_engine import main as faceraw
from run_face_raw_upload import main as facerawupload
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

face_raw_task = PythonOperator(
    task_id='face_raw',
    provide_context=True,
    python_callable=faceraw,
    dag=dag,
)

face_raw_upload_task = PythonOperator(
    task_id='face_raw_upload',
    provide_context=True,
    python_callable=facerawupload,
    dag=dag,
)

face_raw_task >> face_raw_upload_task
#task1 >> task2


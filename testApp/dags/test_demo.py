
from airflow import DAG
from airflow.operators.python_operator import PythonOperator
from airflow.operators.bash_operator import BashOperator
from datetime import datetime
import requests, json
from run_test_func import main as task1
from run_test_func2 import main as task2
#import run_test_func.main as task1
#import run_test_func2.main as task2

default_args = {
  'start_date': datetime.utcnow(),
  'owner': 'airflow',
}

dag = DAG(
    dag_id='test_demo',
    default_args=default_args,
    schedule_interval=None,
)



start_task = PythonOperator(
#start_task = BashOperator(
    task_id ='test_demo_start',
    python_callable=task1,
#    bash_command='python /usr/local/airflow/dags/run_test_func.py',
#    op_kwargs={"data":this.dag_run}, 
    provide_context=True,
    dag=dag
)

second_task = PythonOperator(
#second_task = BashOperator(
    task_id='test_demo_second',
    provide_context=True,
    python_callable=task2,
#    op_kwargs={"data":this.dag_run}, 
#    bash_command='python /usr/local/airflow/dags/run_test_func2.py',
    dag=dag
)


start_task >> second_task


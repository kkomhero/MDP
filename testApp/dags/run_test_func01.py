from datetime import datetime
import requests, json

if __name__ == '__main__':
  json_val = json.dumps(kwargs['dag_run'].conf, ensure_ascii=False)
  snd_val = json_val.encode('utf-8')

  crt_url = 'http://192.168.203.113:7002/mdp/deepmeta/v1/service/mergeFaceinfo'

  headers = {'Content-type': 'application/json; charset=utf-8', 'Accept': 'application/json'}
  res = requests.get(crt_url, data=snd_val, headers=headers)

  if res.status_code == 200:
    print("success.........")
  else:
    print("fail.......")
    raise ValueError('failed get results....')

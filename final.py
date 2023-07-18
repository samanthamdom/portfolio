#Samantha Dominguez Professor Ahmed OOP S23 - Final Project
#Welcome to my final project! In the code following I aimed to find the amount of times Princess Diana is mentioned in articles to prove her iconic legacy.
#The following code extracts data from NYT and formualtes it into a cohesive website that provides the information of how many times she was mentioned and when!
#In order to execute the code, please input "export FLASK_APP=final.py" then follow it with "python -m flask run"
from flask import Flask
import requests

#Extracting data 
key = "B7finLH1JFG1m7ATOG5eNKBuU7M3TAOl"
url = "https://api.nytimes.com/svc/search/v2/articlesearch.json"
years = ['1990','2000','2010','2020']
year_article_count = []

for each in years:
    begin_date = each + '0101'
    end_date = each + '1231'
    params = {'query': 'Princess Diana' ,'api-key': key, 'begin_date': begin_date, 'end_date': end_date}
    data = requests.get(url, params = params)
    banana = data.json()['response']['meta']['hits']
    year_article_count.append(banana)
    
print(year_article_count)

#Loading + Transforming Data
app = Flask(__name__)

@app.route("/")
def diana():
    return "Welcome to my Final for Object Oriented Programming! I have an infinite love for the late Princess Diana. To prove she was iconic please input '/princess' into the search bar"

@app.route("/princess")
def princess():
    text = []
    for index,value in enumerate(years):
        count = year_article_count[index]
        sentence = f"In the year {value}, Princess Diana was published {count} times"
        text.append(sentence)   
    text.append("\n This goes to show her true iconic legacy even after her unfortunate passing. Hope you enjoyed my final! Have a great summer! :) ")
    return ("\n".join(text)) 

        
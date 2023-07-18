#Samantha Dominguez, OOP23, Professor Ahmed, Midterm Assignment
#To execute I used 'python -m flask run', if that does not work, use 'export FLASK_APP=midterm.py' first then use the command previously mentioned next!
#The purpose of this code is to create my own basic website with the python package Flask!

from flask import Flask
from flask import url_for
import random
website_index = {'home page' : 'hello!', 'second page' : 'beans', 'third page' : 'your fortune' , 'fourth page' : 'the one you are on right now' ,'fifth page': 'bye'}

app = Flask(__name__)

@app.route("/")
def hello():
    return "Greetings! Tis I, Samantha Dominguez! Welcome to my midterm project for Object Oriented Programming! To get to the next page input this into the existing url: /beans/ a chosen name for a pet!"

@app.route("/beans/<name>")
def beans(name):   
    return f"I live with a pet named {name}! Now to see your fortune...delete '/beans/name' and insert '/myfortune' " 

@app.route("/myfortune")
def fortune():
    randomnum = random.randint(1,2)
    if randomnum == 1:
        return "The skies says you are going to have an okay day...beware of green squirrels. To view the directory, delete '/myfortune' and insert '/directory' or '/bye' if you're bored. "
    else:
        return "The skies say you are going to have a FANTABULOUS day! To view the directory, delete '/myfortune' and insert '/directory' or '/bye' if you're bored! "

@app.route("/directory")
def directory():
        return website_index

@app.route("/bye")
def bye():
    result = ""
    for _ in range(0,1):
        with app.test_request_context():
            url = url_for('bye')
            result += "Hope you enjoyed! This is the end as you have reached the last url named: " + url
    return result

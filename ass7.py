from flask import Flask,request


app = Flask(__name__)


class Match:
    win=0
    loss=0
    tie=0
    def addWin(self,x):
        self.win+=x
        return self.win

cl = Match()

@app.route('/score',methods = ["GET"])
def displayScore():
    return {"winssss":cl.win,"lossss":cl.loss,"tiessss":cl.tie}

@app.route('/add',methods = ["POST"])
def addScore():
    global cl
    temp = request.get_json()
    cl.addWin(temp["wins"])
    # wins+=temp['wins']
    return {"winssss":cl.win}

if(__name__ == "__main__"):
    app.run(debug=True)
# @app.route



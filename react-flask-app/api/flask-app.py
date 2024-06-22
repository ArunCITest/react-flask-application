from flask import Flask
import time

app=Flask(__name__)

@app.route('/time', methods=['GET'])
def get_current_time():
    return {time: time.time()}

if __name__ == '__main__':
    app.run()
    
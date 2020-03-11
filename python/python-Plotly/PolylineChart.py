#-*- coding:utf-8 -*-

import plotly
import plotly.offline as py
import numpy as np
import plotly.graph_objs as go
import xlrd
from datetime import datetime
from xlrd import xldate_as_tuple
import requests
import pandas
import time

# setting offilne
plotly.offline.init_notebook_mode(connected=True)

N = 100
random_x = np.linspace(0, 10, N)
random_y0 = np.random.randn(N) + 5
random_y1 = np.random.randn(N)
random_y2 = np.random.randn(N) - 5

def polylineChart():
    # Create traces
    trace0 = go.Scatter(
        x=random_x,
        y=random_y0,
        mode='markers',
        name='markers'
    )
    trace1 = go.Scatter(
        x=random_x,
        y=random_y1,
        mode='lines+markers',
        name='lines+markers'
    )
    trace2 = go.Scatter(
        x=random_x,
        y=random_y2,
        mode='lines',
        name='lines'
    )
    data = [trace1]
    py.plot(data)

def scatterChart():
    trace1 = go.Scatter(
        y=np.random.randn(500),
        mode='markers',
        marker=dict(
            size=16,
            color=np.random.randn(500),
            colorscale='Viridis',
            showscale=True
        )
    )
    data = [trace1]
    py.plot(data)

def columnarChart():
    trace0 = go.Bar(
        x=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
           'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        y=[20, 14, 25, 16, 18, 22, 19, 15, 12, 16, 14, 17],
        name='Primary Product',
        marker=dict(
            color='rgb(49,130,189)'
        )
    )
    trace1 = go.Bar(
        x=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
           'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        y=[19, 14, 22, 14, 16, 19, 15, 14, 10, 12, 12, 16],
        name='Secondary Product',
        marker=dict(
            color='rgb(204,204,204)'
        )
    )
    data = [trace0, trace1]
    py.plot(data)

def readExeclData():
    """
    ctype： 0 empty,1 string, 2 number, 3 date, 4 boolean, 5 error
    :return:
    """
    data = xlrd.open_workbook('每日疫情.xlsx')
    table = data.sheet_by_name('Sheet1')
    print("总行数：" + str(table.nrows))
    print("总列数：" + str(table.ncols))
    lie1,lie2,lie3 = [],[],[]
    for nclo in [0,1,2]:
        for row in range(table.nrows):
            ctype1 = table.cell(row,nclo).ctype
            cell = table.cell_value(row,nclo)
            if ctype1 == 3 and nclo == 0:
                date = datetime(*xldate_as_tuple(cell, 0))
                cell = date.strftime('%y-%m-%d')
                lie1.append(cell)
            elif ctype1 == 2 and nclo == 1:
                cell = int(cell)
                lie2.append(cell)
            elif nclo == 2:
                cell = int(cell)
                lie3.append(cell)
    return [lie1,lie2,lie3]


def timetest():
    updateTimes=[]
    currentConfirmedCounts,confirmedCounts = [],[]
    a = requests.get("https://lab.isaaclin.cn/nCoV/api/area?latest=0&province=%E6%B9%96%E5%8C%97%E7%9C%81")
    res = a.json()
    result = res["results"]
    for res in result:
        updateTime = res["updateTime"]
        updateTimes.append(updateTime)
        if "currentConfirmedCount" in res:
            currentConfirmedCounts.append(res["currentConfirmedCount"])
        else:
            currentConfirmedCounts.append(0)
        if "confirmedCount" in res:
            confirmedCounts.append(res["confirmedCount"])
        else:
            confirmedCounts.append(0)
    time1 = [ datetime.fromtimestamp(int(str(i)[0:-3])).strftime("%Y-%m-%d %H:%M:%S") for i in updateTimes ]
    random_x = np.array(time1)
    random_y1 =np.array(currentConfirmedCounts)
    random_y2 = np.array(confirmedCounts)
    trace1 = go.Scatter(
        x=random_x,
        y=random_y1,
        mode='lines+markers',
        name='lines+markers'
    )
    trace2 = go.Scatter(
        x=random_x,
        y=random_y2,
        mode='lines+markers',
        name='lines+markers'
    )
    data = [trace1,trace2]
    py.plot(data)

timetest()
#-*- coding:utf-8 -*-

import requests
from datetime import datetime
import plotly
import plotly.offline as py
import numpy as np
import plotly.graph_objs as go

try:
    res = requests.get("https://lab.isaaclin.cn/nCoV/api/area?latest=0&province=广东省")
    if res.status_code == 200:
        res = res.json()
        results = res["results"]
    else:
        print("request failed")
except(ConnectionError):
    print("Connect error")

def getEpidemicData(etype,*edate):

    ecount = []
    for result in results:
        update = result["updateTime"]
        if update in edate:
            enumber = result.get(etype,0)
            ecount.append(enumber)
    return ecount

def getEpidemicDate():

    updateTimes = list()
    for result in results:
        updateTime = result["updateTime"]
        updateTimes.append(updateTime)

    nDateMax = []
    m = datetime.fromtimestamp(int(str(updateTimes[0])[0:-3])).strftime("%Y-%m-%d")
    m1 = 0
    for i in updateTimes:
        stampYmd = datetime.fromtimestamp(int(str(i)[0:-3])).strftime("%Y-%m-%d")
        if stampYmd == m:
            if i >= m1:
                mmax = i
                m1 = mmax
            continue
        nDateMax.append(mmax)
        m = stampYmd
        m1 = i
        mmax = i
    nDates = [datetime.fromtimestamp(int(str(i)[0:-3])).strftime("%Y-%m-%d") for i in nDateMax]
    return nDates,nDateMax

def printGrandTotalData():
    """
    累计确诊、现存确诊、累计治愈、累计死亡
    :return:
    """

    nDates, nDateMax = getEpidemicDate()
    confirmedCount = getEpidemicData("confirmedCount", *nDateMax)
    #currentConfirmedCount = getEpidemicData("currentConfirmedCount", *nDateMax)
    curedCount = getEpidemicData("curedCount", *nDateMax)
    deadCount = getEpidemicData("deadCount", *nDateMax)
    currentConfirmedCount = [confirmedCount[i] - curedCount[i] - deadCount[i] for i in range(len(confirmedCount))]

    random_x = np.array(nDates)
    random_y1 = np.array(confirmedCount)
    random_y2 = np.array(currentConfirmedCount)
    random_y3 = np.array(curedCount)
    random_y4 = np.array(deadCount)

    trace1 = go.Scatter(
        x=random_x,
        y=random_y1,
        mode='lines+markers',
        name='累计确诊'
    )

    trace2 = go.Scatter(
        x=random_x,
        y=random_y2,
        mode='lines+markers',
        name='现存确诊'
    )

    trace3 = go.Scatter(
        x=random_x,
        y=random_y3,
        mode='lines+markers',
        name='累计治愈'
    )

    trace4 = go.Scatter(
        x=random_x,
        y=random_y4,
        mode='lines+markers',
        name='累计死亡'
    )

    data = [trace1,trace2,trace3,trace4]
    '''创建layout对象'''
    layout = go.Layout(title='广东省',
                       font={
                           'size': 14,
                           'family': 'sans-serif',
                           'color': 'blueviolet'
                       })
    '''将graph部分和layout部分组合成figure对象'''
    fig = go.Figure(data=data, layout=layout)
    py.plot(fig)

def printAddData():

    nDates, nDateMax = getEpidemicDate()

    confirmedCount = getEpidemicData("confirmedCount", *nDateMax)
    curedCount = getEpidemicData("curedCount", *nDateMax)
    deadCount = getEpidemicData("deadCount", *nDateMax)

    dailyConfirmed = [ confirmedCount[i] - confirmedCount[i+1] for i in range(0,len(confirmedCount)-1)]
    dailyConfirmed.append(0)

    dailyCured = [curedCount[i] - curedCount[i + 1] for i in range(0, len(curedCount) - 1)]
    dailyCured.append(0)

    dailyDead = [deadCount[i] - deadCount[i + 1] for i in range(0, len(deadCount) - 1)]
    dailyDead.append(0)

    random_x = np.array(nDates)
    random_y1 = np.array(dailyConfirmed)
    random_y2 = np.array(dailyCured)
    random_y3 = np.array(dailyDead)

    trace1 = go.Scatter(
        x=random_x,
        y=random_y1,
        mode='lines+markers',
        name='新增确诊'
    )
    trace2 = go.Scatter(
        x=random_x,
        y=random_y2,
        mode='lines+markers',
        name='新增治愈'
    )

    trace3 = go.Scatter(
        x=random_x,
        y=random_y3,
        mode='lines+markers',
        name='新增死亡'
    )

    data = [trace1,trace2,trace3]
    py.plot(data)


printAddData()
printGrandTotalData()
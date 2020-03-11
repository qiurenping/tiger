# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import re


try:
    r = requests.get(url='https://3g.dxy.cn/newh5/view/pneumonia')
except requests.exceptions.ChunkedEncodingError:
    print("error")
soup = BeautifulSoup(r.content, 'lxml')
resa = soup.find('script', attrs={'id': 'getStatisticsService'})
print(resa)
overall_information = re.search(r'\{("id".*?)\}\}',str(resa))
print(overall_information)

overall_information = re.search(r'\{("id".*?)\}\}', str(soup.find('script', attrs={'id': 'getStatisticsService'})))
print(overall_information)
province_information = re.search(r'\[(.*?)\]', str(soup.find('script', attrs={'id': 'getListByCountryTypeService1'})))
area_information = re.search(r'\[(.*)\]', str(soup.find('script', attrs={'id': 'getAreaStat'})))
abroad_information = re.search(r'\[(.*)\]', str(soup.find('script', attrs={'id': 'getListByCountryTypeService2'})))
news = re.search(r'\[(.*?)\]', str(soup.find('script', attrs={'id': 'getTimelineService'})))
rumors = re.search(r'\[(.*?)\]', str(soup.find('script', attrs={'id': 'getIndexRumorList'})))

print(province_information)
print(area_information)
print(abroad_information)
print(news)
print(rumors)
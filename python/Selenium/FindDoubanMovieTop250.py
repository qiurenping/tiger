# -*- coding:UTF-8 -*-

import time
import requests
from selenium import webdriver
from selenium.webdriver.common.by import By
import os

def get_images():
    driver = webdriver.Chrome()
    starts = [0,25,50,75,100,125,150,175,200,225,250]
    for index in starts:
        url = 'https://movie.douban.com/top250?start='+str(index)+'&filter='
        driver.get(url)
        time.sleep(10)
        imgs = driver.find_elements(By.TAG_NAME, 'img')
        for img in imgs:
            img_url = img.get_attribute('src')
            img_title = img.get_attribute('alt')
            save_file(img_url,img_title)
    driver.close()

def save_file(url,name):
    r = requests.get(url,verify=False)
    title = name + '.png'
    image_file = os.path.dirname(os.path.dirname(__file__)) + '/Selenium/images/%s' % (title)
    with open(image_file, 'wb') as f:
        f.write(r.content)

get_images()
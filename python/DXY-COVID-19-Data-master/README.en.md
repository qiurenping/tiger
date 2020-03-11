# COVID-19/2019-nCoV Time Series Infection Data Warehouse

[简体中文](README.md) | English

COVID-19/2019-nCoV time series infection data warehouse, the data source is [Ding Xiang Yuan](https://3g.dxy.cn/newh5/view/pneumonia).

**Researchers**  
Recently, many college teachers and students contacted me, 
hoping to use these data for scientific research. 
However, not everyone is familiar with the use of APIs and the format of JSON, 
so here is the [data warehouse](https://github.com/BlankerL/DXY-COVID-19-Data) 
to publish the latest data in CSV format, 
which can be easily processed and loaded by most software.

The data is obtained by [COVID-19 Infection Data Realtime Crawler](https://github.com/BlankerL/DXY-COVID-19-Crawler). 
The data will be published hourly. 

#### CSV File List
1. Overall Data [DXYOverall.csv](csv/DXYOverall.csv)
2. Regional Data [DXYArea.csv](csv/DXYArea.csv)(Including city names in English)
3. News [DXYNews.csv](csv/DXYNews.csv)
4. Rumors [DXYRumors.csv](csv/DXYRumors.csv)

Regional data ([DXYArea.csv](csv/DXYArea.csv))
only contains all the city-level data. 
Data from Hong Kong SAR, Macao SAR, Tai Wan and Tibet are province-level, 
and not city-level data available from DXY, so they are not in this file. 

If needed, you can modify the [`csv_dumper()`](https://github.com/BlankerL/DXY-COVID-19-Data/blob/8e21a7e27604a9d2b1dcf0fa3d0266aa68576753/script.py#L107)
function to customize your own files. 

#### JSON File List
Due to the instability of API,
this project will also push latest static JSONs into the `json` folder. 
Data from JSON files are exactly the same as the data responded from the API.

Data customization is not accepted. 
If you have more requirements for data, please handle it on your own.

## Data Description
1. As mentioned in [Issue #21](https://github.com/BlankerL/DXY-COVID-19-Data/issues/21), 
Some data are duplicated. For example, in Henan Province, 
there is a city-level document recording Nanyang (Dengzhou inclusive) and Dengzhou.
Therefore, the data of "Dengzhou" will be double-counted once during the summation.

### Noise Data
At present, some time series data in Zhejiang and Hubei are found containing noises. 
The possible reason is the manually processed data were recorded by mistake. 

The crawler just crawl what it sees, do not deal with any noise data. 
Therefore, if you use the data for scientific research, please preprocess and clean the data properly. 

In the meantime, I opened an [issue](https://github.com/BlankerL/DXY-COVID-19-Crawler/issues/34) 
for you to report the potential noise data. I will check and remove them periodically. 

## Reference

### Packages
1. If you would like to analyze the data with [R](https://www.r-project.org/),
you can refer to [pzhaonet/ncovr](https://github.com/pzhaonet/ncovr).
This project will help you to directly load data into R from either GitHub Data Warehouse or API. 

### Analysis
1. [jianxu305/nCov2019_analysis](https://github.com/jianxu305/nCov2019_analysis)  
   Features: See [here](https://github.com/jianxu305/nCov2019_analysis/blob/master/src/demo.pdf).
2. [lyupin/Visualize-DXY-2019-nCov-Data](https://github.com/lyupin/Visualize-DXY-2019-nCov-Data)  
   Features: See [here](https://github.com/lyupin/Visualize-DXY-2019-nCov-Data/blob/master/readme.md).
3. [Avens666/COVID-19-2019-nCoV-Infection-Data-cleaning-](https://github.com/Avens666/COVID-19-2019-nCoV-Infection-Data-cleaning-)  
   Features: See [here](https://github.com/Avens666/COVID-19-2019-nCoV-Infection-Data-cleaning-/blob/master/README.md)

**Wish you all the best.**

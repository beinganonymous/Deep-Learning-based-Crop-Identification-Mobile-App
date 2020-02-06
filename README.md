# Deep-Learning-based-Crop-Identification-Mobile-App
Develop a mobile application that can identify crop using only field photo of a crop. The team must target at-least 10 different crops for demonstration. The application will allow the user to take photos and automatically identify the crop. The photo and crop information along with geolocation information should be stored in an internal database which can be exported/emailed.

## Introduction.
Android application that will identify the crop using field photo of the crop.
The information about crop and geolocation of the crop will be stored in internal database.
All this information can be exported in Excel file.
Using this information prediction of which crops can grow in this area can be obtained.

## Dependencies
* NodeJS
* TorchVision
* fastai==1.0.52
* aiofiles==0.4.0
* aiohttp==3.5.4
* asyncio==3.4.3
* numpy==1.16.3
* starlette==0.12.0
* uvicorn==0.7.1
* python-multipart==0.0.5

## Implementation
1. Install above dependencies and run ```train.py``` file.
2. Deploy trained model on server by running ```server.py``` file using following command ```python server.py serve```
3. Run app on Android Studio and build apk.

## ScreenShots
#### Select Image
![main](https://user-images.githubusercontent.com/30001594/73961151-0f2cad00-4932-11ea-8526-aecfd1c5e9bf.jpeg) 
#### Model Recognize type of Crop
![second](https://user-images.githubusercontent.com/30001594/73962402-5e73dd00-4934-11ea-95b4-1fc09a13c83b.jpeg)
#### Information about Crop
![third](https://user-images.githubusercontent.com/30001594/73962459-7ea39c00-4934-11ea-931a-ecf7c8eaeddc.jpeg)

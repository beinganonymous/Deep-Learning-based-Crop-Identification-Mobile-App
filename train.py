
from fastai.vision import *
from fastai.metrics import error_rate

bs=64

import os
os.listdir(os.getcwd())

data = ImageDataBunch.from_folder(path=os.getcwd(), ds_tfms=get_transforms(), train='train', valid='val',size=224,bs=8).normalize(imagenet_stats)

data.show_batch(rows=2, figsize=(5,5))

data.classes

learn_50 = cnn_learner(data, models.resnet34, metrics=[accuracy, error_rate])

learn_50.fit_one_cycle(10)

learn_50.export('/content/models/abc.pkl')

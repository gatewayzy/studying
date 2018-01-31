"""
每个app可以设置独立的urls文件，在总的web管理中进行引用即可
"""
from django.conf.urls import url
from .mvc.controller import home

urlpatterns = [
    url(r'^$', home.index),
    url(r'^home$', home.home),
    url(r'^home2$', home.home2),
]

"""
app_model的路由信息
"""

from django.conf.urls import url
from .mvc.controller import home

urlpatterns = [
    url(r'^$', home.index),
    url(r'^home$', home.home),
    url(r'^home2$', home.home2),
]
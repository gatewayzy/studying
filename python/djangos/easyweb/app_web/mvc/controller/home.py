"""
首页
"""
from django.http import HttpResponse
from django.shortcuts import render

print(__doc__)


def index(request):
    """
    request参数是必须的，返回的形式是html文本，不适合复杂页面展示
    :param request:
    :return:
    """
    text = '<h3>欢迎访问django的简单web，<a href="/web/home">查看网站目录</a></h3>'
    return HttpResponse(text)


def home(request):
    data = {'title': '标题：app-web首页', 'userName': 'Jack'}
    return render(request, 'home.html', data)


def home2(request):
    return render(request, 'home2.html', {'title': '标题：app-web首页子页面'})

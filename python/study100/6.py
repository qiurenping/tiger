#!/bin/bash

def fib(n):
	a=0
	b=1
	for i in range(2,n+2):
		print a
		a,b = b,a+b

fib(5)
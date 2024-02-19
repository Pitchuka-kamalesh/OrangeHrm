@echo off

mvn clean test

cd  target/allure-results

allure serve .




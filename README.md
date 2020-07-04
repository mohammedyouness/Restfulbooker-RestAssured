# REST-assured Example
---
Overview
---

This project provides an example of how to use the [REST-assured](http://rest-assured.io/) library to write black-box, functional tests for REST APIs in Java.

As an example of live RESTful API, I use: https://restful-booker.herokuapp.com/apidoc/index.html

In this example project, REST-assured is used to implement a suite of functional tests for a couple of REST APIs
hosted on [Restful-booker](https://restful-booker.herokuapp.com) that supports creating, retrieving, updating, and deleting a resource/entity known as a (booking),
via HTTP POST, GET, PATCH, & DELETE methods.

This Project covers:
- Implementing CRUD functionality.
- Using Authorization through creating a token for creating and updating bookings
- Using deserialization through sending POJOs AS JSON Objects to the server

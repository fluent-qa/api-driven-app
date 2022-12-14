# coding: utf-8

"""
    Todos API

    Documentation of a simple Todos API

    The version of the OpenAPI document: 0.0.2
    Generated by: https://openapi-generator.tech
"""


from fastapi import FastAPI

from openapi_server.apis.healthcheck_api import router as HealthcheckApiRouter
from openapi_server.apis.todo_api import router as TodoApiRouter

app = FastAPI(
    title="Todos API",
    description="Documentation of a simple Todos API",
    version="0.0.2",
)

app.include_router(HealthcheckApiRouter)
app.include_router(TodoApiRouter)

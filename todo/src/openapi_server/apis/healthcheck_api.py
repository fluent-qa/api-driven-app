# coding: utf-8

from typing import Dict, List  # noqa: F401

from fastapi import (  # noqa: F401
    APIRouter,
    Body,
    Cookie,
    Depends,
    Form,
    Header,
    Path,
    Query,
    Response,
    Security,
    status,
)

from openapi_server.models.extra_models import TokenModel  # noqa: F401


router = APIRouter()


@router.get(
    "/healthy",
    responses={
        200: {"description": "Service is healthy"},
        503: {"description": "Service isn&#39;t healthy"},
    },
    tags=["healthcheck"],
    summary="Get the healthiness of the service",
    response_model_by_alias=True,
)
async def is_healthy(
) -> None:
    ...


@router.get(
    "/ready",
    responses={
        200: {"description": "Service is ready"},
        503: {"description": "Service isn&#39;t ready yet"},
    },
    tags=["healthcheck"],
    summary="Get the readiness of the service",
    response_model_by_alias=True,
)
async def is_ready(
) -> None:
    ...

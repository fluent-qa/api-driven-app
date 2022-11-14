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
from openapi_server.models.error import Error
from openapi_server.models.todo import Todo


router = APIRouter()


@router.post(
    "/v1/todos",
    responses={
        200: {"model": Todo, "description": "Successfully created a new todo"},
        400: {"model": Error, "description": "Request badly formatted"},
        429: {"model": Error, "description": "Too many requests were sent"},
    },
    tags=["todo"],
    summary="Create a new todo",
    response_model_by_alias=True,
)
async def create_todo(
    todo: Todo = Body(None, description="New todo payload"),
) -> Todo:
    """Create a new todo"""
    ...


@router.delete(
    "/v1/todos/{todoUuid}",
    responses={
        204: {"description": "Successful response"},
        400: {"model": Error, "description": "Request badly formatted"},
    },
    tags=["todo"],
    summary="Delete a todo",
    response_model_by_alias=True,
)
async def delete_todo(
    todoUuid: str = Path(None, description=""),
    owner_uuid: str = Query(None, description=""),
    hard: bool = Query(None, description="Defines if the deletion is a \&quot;hard\&quot; delete (true) or a \&quot;soft\&quot; delete (false or not present) "),
) -> None:
    """Delete a todo by providing its uuid"""
    ...


@router.get(
    "/v1/todos/{todoUuid}",
    responses={
        200: {"model": Todo, "description": "Successfully retrieved the todo"},
        400: {"model": Error, "description": "Request badly formatted"},
        404: {"description": "Couldn&#39;t find the todo with the provided uuid"},
        429: {"model": Error, "description": "Too many requests were sent"},
    },
    tags=["todo"],
    summary="Get a todo",
    response_model_by_alias=True,
)
async def get_todo(
    owner_uuid: str = Query(None, description=""),
    todoUuid: str = Path(None, description=""),
) -> Todo:
    """Get a todo by providing its uuid"""
    ...


@router.get(
    "/v1/todos",
    responses={
        200: {"model": List[Todo], "description": "Successfully retrieved all the todos"},
        400: {"model": Error, "description": "Request badly formatted"},
        429: {"model": Error, "description": "Too many requests were sent"},
    },
    tags=["todo"],
    summary="List all the todos",
    response_model_by_alias=True,
)
async def list_todos(
    owner_uuid: str = Query(None, description=""),
) -> List[Todo]:
    """List all the todos of the user provided in the query parameters"""
    ...


@router.put(
    "/v1/todos/{todoUuid}",
    responses={
        200: {"model": Todo, "description": "Successful response"},
        400: {"model": Error, "description": "Request badly formatted"},
        429: {"model": Error, "description": "Too many requests were sent"},
    },
    tags=["todo"],
    summary="Update a todo",
    response_model_by_alias=True,
)
async def update_todo(
    owner_uuid: str = Query(None, description=""),
    todoUuid: str = Path(None, description=""),
    todo: Todo = Body(None, description="New todo payload"),
) -> Todo:
    """Update a todo by providing its uuid and the updated todo content"""
    ...

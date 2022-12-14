# generated by fastapi-codegen:
#   filename:  openapi3-todo.yaml
#   timestamp: 2022-10-26T14:53:57+00:00

from __future__ import annotations

from typing import List, Optional, Union

from fastapi import FastAPI, Path, Query

from .models import Error, Todo

app = FastAPI(
    title='Todos API',
    description='Documentation of a simple Todos API',
    version='0.0.2',
    servers=[
        {'url': 'https://test-api.temp.com', 'description': 'Production'},
        {'url': 'localhost', 'description': 'Development server'},
    ],
)


@app.get('/healthy', response_model=None)
def is_healthy() -> None:
    """
    Get the healthiness of the service
    """
    pass


@app.get('/ready', response_model=None)
def is_ready() -> None:
    """
    Get the readiness of the service
    """
    pass


@app.get(
    '/v1/todos',
    response_model=List[Todo],
    responses={'400': {'model': Error}, '429': {'model': Error}},
)
def list_todos(
    owner_uuid: str = Query(..., alias='ownerUuid')
) -> Union[List[Todo], Error]:
    """
    List all the todos
    """
    pass


@app.post(
    '/v1/todos',
    response_model=Todo,
    responses={'400': {'model': Error}, '429': {'model': Error}},
)
def create_todo(body: Todo = None) -> Union[Todo, Error]:
    """
    Create a new todo
    """
    pass


@app.get(
    '/v1/todos/{todo_uuid}',
    response_model=Todo,
    responses={'400': {'model': Error}, '429': {'model': Error}},
)
def get_todo(
    owner_uuid: str = Query(..., alias='ownerUuid'),
    todo_uuid: str = Path(..., alias='todoUuid'),
) -> Union[Todo, Error]:
    """
    Get a todo
    """
    pass


@app.put(
    '/v1/todos/{todo_uuid}',
    response_model=Todo,
    responses={'400': {'model': Error}, '429': {'model': Error}},
)
def update_todo(
    owner_uuid: str = Query(..., alias='ownerUuid'),
    todo_uuid: str = Path(..., alias='todoUuid'),
    body: Todo = None,
) -> Union[Todo, Error]:
    """
    Update a todo
    """
    pass


@app.delete(
    '/v1/todos/{todo_uuid}', response_model=None, responses={'400': {'model': Error}}
)
def delete_todo(
    todo_uuid: str = Path(..., alias='todoUuid'),
    owner_uuid: str = Query(..., alias='ownerUuid'),
    hard: Optional[bool] = None,
) -> Union[None, Error]:
    """
    Delete a todo
    """
    pass

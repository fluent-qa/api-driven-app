# coding: utf-8

from fastapi.testclient import TestClient


from openapi_server.models.error import Error  # noqa: F401
from openapi_server.models.todo import Todo  # noqa: F401


def test_create_todo(client: TestClient):
    """Test case for create_todo

    Create a new todo
    """
    todo = {"uuid":"3d780d09-c520-4817-b430-ce849bcc5423","owner_uuid":"535d6711-2ec0-4ba7-9f34-3d13f25de822","title":"Groceries","state":"ACTIVE"}

    headers = {
    }
    response = client.request(
        "POST",
        "/v1/todos",
        headers=headers,
        json=todo,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_delete_todo(client: TestClient):
    """Test case for delete_todo

    Delete a todo
    """
    params = [("owner_uuid", 'owner_uuid_example'),     ("hard", True)]
    headers = {
    }
    response = client.request(
        "DELETE",
        "/v1/todos/{todoUuid}".format(todoUuid='todo_uuid_example'),
        headers=headers,
        params=params,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_get_todo(client: TestClient):
    """Test case for get_todo

    Get a todo
    """
    params = [("owner_uuid", 'owner_uuid_example')]
    headers = {
    }
    response = client.request(
        "GET",
        "/v1/todos/{todoUuid}".format(todoUuid='todo_uuid_example'),
        headers=headers,
        params=params,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_list_todos(client: TestClient):
    """Test case for list_todos

    List all the todos
    """
    params = [("owner_uuid", 'owner_uuid_example')]
    headers = {
    }
    response = client.request(
        "GET",
        "/v1/todos",
        headers=headers,
        params=params,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_update_todo(client: TestClient):
    """Test case for update_todo

    Update a todo
    """
    todo = {"uuid":"3d780d09-c520-4817-b430-ce849bcc5423","owner_uuid":"535d6711-2ec0-4ba7-9f34-3d13f25de822","title":"Groceries","state":"ACTIVE"}
    params = [("owner_uuid", 'owner_uuid_example')]
    headers = {
    }
    response = client.request(
        "PUT",
        "/v1/todos/{todoUuid}".format(todoUuid='todo_uuid_example'),
        headers=headers,
        json=todo,
        params=params,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


# coding: utf-8

from fastapi.testclient import TestClient




def test_is_healthy(client: TestClient):
    """Test case for is_healthy

    Get the healthiness of the service
    """

    headers = {
    }
    response = client.request(
        "GET",
        "/healthy",
        headers=headers,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_is_ready(client: TestClient):
    """Test case for is_ready

    Get the readiness of the service
    """

    headers = {
    }
    response = client.request(
        "GET",
        "/ready",
        headers=headers,
    )

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


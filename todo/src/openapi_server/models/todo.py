# coding: utf-8

from __future__ import annotations
from datetime import date, datetime  # noqa: F401

import re  # noqa: F401
from typing import Any, Dict, List, Optional  # noqa: F401

from pydantic import AnyUrl, BaseModel, EmailStr, Field, validator  # noqa: F401


class Todo(BaseModel):
    """NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

    Do not edit the class manually.

    Todo - a model defined in OpenAPI

        uuid: The uuid of this Todo.
        owner_uuid: The owner_uuid of this Todo.
        title: The title of this Todo.
        state: The state of this Todo.
        description: The description of this Todo [Optional].
    """

    uuid: str = Field(alias="uuid")
    owner_uuid: str = Field(alias="ownerUuid")
    title: str = Field(alias="title")
    state: str = Field(alias="state")
    description: Optional[str] = Field(alias="description", default=None)

Todo.update_forward_refs()

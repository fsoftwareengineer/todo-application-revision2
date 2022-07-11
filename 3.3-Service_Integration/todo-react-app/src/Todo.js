import React, { useState, useEffect } from "react";
import {
  ListItem,
  ListItemText,
  InputBase,
  Checkbox,
  ListItemSecondaryAction,
  IconButton,
} from "@mui/material";
import DeleteOutlined from "@mui/icons-material/DeleteOutlined";

const Todo = (props) => {
  const [item, setItem] = useState(props.item);
  const [readOnly, setReadOnly] = useState(true);
  const deleteItem = props.deleteItem;
  const editItem = props.editItem;

  const editEventHandler = (e) => {
    setItem({...item, title: e.target.value});
  };

  const checkboxEventHandler = (e) => {
    item.done = e.target.checked;
    editItem(item);
  }

  // deleteEventHandler 작성
  const deleteEventHandler = () => {
    deleteItem(item);
  };

  const turnOffReadOnly = () => {
    setReadOnly(false);
  }

  // turnOnReadOnly 함수 작성
  const turnOnReadOnly = (e) => {
    if (e.key === "Enter" && readOnly === false) {
        setReadOnly(true);
        editItem(item);
    }
  };

  return (
    <ListItem>
      <Checkbox checked={item.done}
      onChange={checkboxEventHandler} />
      <ListItemText>
        <InputBase
          inputProps={{ 
              "aria-label": "naked",
              readOnly: readOnly }}
          onClick={turnOffReadOnly}
          onKeyDown={turnOnReadOnly}
          onChange={editEventHandler}
          type="text"
          id={item.id}
          name={item.id}
          value={item.title}
          multiline={true}
          fullWidth={true}
        />
      </ListItemText>
      <ListItemSecondaryAction>
        <IconButton aria-label="Delete Todo"
          onClick={deleteEventHandler} >
          <DeleteOutlined />
        </IconButton>
      </ListItemSecondaryAction>
    </ListItem>
  );
};

export default Todo;

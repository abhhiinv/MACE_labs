import React, {useState} from "react";
function List(){
    const [items, setItems] = useState([]);
    const [newItem, setNewItem] = useState('');
    const addItem = () => {
        if(newItem.trim()==='') return;
        setItems([...items,newItem]);
        setNewItem('');
    };
    return (
        <div style={{padding:"20px"}}>
            <h2>My Item List</h2>
            <input type="text" value={newItem}onChange={(e)=>setNewItem(e.target.value)} placeholder="Enter new item"></input>
            <button onClick={addItem}>Add</button>
            <ul>
                {items.map((item,index)=>(<li key ={index}>{item}</li>))}
            </ul>
        </div>
    );
}
export default List;
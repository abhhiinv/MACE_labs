import React,{Component} from "react";
class Counter extends Component{
    constructor(props){
        super(props);
        this.state={
            count: 0
        };
    } 
    increment = () => {
        this.setState({count: this.state.count+1});
    };
    decrement = () => {
        this.setState({count: this.state.count-1});
    };
    reset = () =>{
        this.setState({count: 0});
    };
    render() {
        return (
            <div style={{textAlign:"center",marginTop:"20px",marginLeft:"40rem"}}>
                <h2>Counter : {this.state.count}</h2>
                <button onClick={this.decrement}>Decrement</button>
                <button onClick={this.increment} style={{marginLeft:"10px"}}>Increment</button>
                <button onClick={this.reset} style={{marginLeft:"10px"}}>Reset</button>
            </div>
        );
    }
}
export default Counter;
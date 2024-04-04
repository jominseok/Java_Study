import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom'

function App() {

  //음악을 조회하고 등록하는 사이트를 구현하세요.
  //음악 조회는 / 에서
  //음악 등록은 /insert에서 
  //음악 등록시 음악번호(숫자), 제목, 가수, 장르를 입력하여 등록
  //음악 번호는 중복되지 않게 입력해서 추가
  //음악 조회에서 음악 삭제버튼을 클릭하면 삭제되도록 구현
  //   : 음악번호를 이용하여 삭제
  let [list, setList] = useState([]);

  function add(muvie){
    setList([muvie, ...list]);
  }
  function remove(num){
    let tmpList = list.filter(item=>item.num != num);
    setList(tmpList);
  }
  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path="/" exact element={<List list={list} add={add} remove={remove}/>} />
        <Route path="/add" element={<Add/>} />
      </Routes>
    </BrowserRouter>
  );
}
function Nav(){
  return (
    <div className='box'>
      <ul className="menu-list">
        <li><Link to="/">List</Link></li>
        <li><Link to="/add">Add new Movie</Link></li>
      </ul>
    </div>
  );
}
function List({list, add, remove}){

  const location = useLocation();
  let movie = location.state;
  
  if(movie != null){
    add(movie);
    location.state = null;
  }

  return (
    <div className='box'>
      <h1>Movies</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item)=>{
              return (
                <tr key={item.num}>
                  <td>{item.num}</td>
                  <td>{item.title}</td>
                  <td>{item.genre}</td>
                  <td>{item.date}</td>
                  <td><button onClick={()=>remove(item.num)}>Delete</button></td>
                </tr>
              )
            })
          }
          
        </tbody>
      </table>
    </div>
  );
}
function Add(){
  let [num, setNum] = useState(0);
  let [genre, setGenre] = useState("");
  let [title, setTitle] = useState("");
  let [date, setDate] = useState("");

  const numChange = (e) => setNum(e.target.value);
  const genreChange = (e) => setGenre(e.target.value);
  const titleChange = (e) => setTitle(e.target.value);
  const dateChange = (e) => setDate(e.target.value);

  const navigate = useNavigate();

  function nullCheck(){
    if(num == 0 || genre == "" || title == "" || date == ""){
      alert("전부다 입력해주세요");
      window.location.reload();
      return false;
    }
    return true;
  }

  function addMusic(){
    if(nullCheck()){
      navigate("/",{
        state : {
          title,
          genre,
          num,
          date
        }
      })
    }
   
  }

  return (
    <div className='box'>
      <h1>Create Movie</h1>
      <div>
        <input type="number" onChange={numChange} placeholder='Input movie id'/>
      </div>
      <div>
        <input type="text" onChange={titleChange} placeholder='Input movie title'/>
      </div>
      <div>
        <input type="text" onChange={genreChange} placeholder='Input movie genre'/>
      </div>
      <div>
        <label>출시일</label>
        <input type="date" onChange={dateChange}/>
      </div>
      <button onClick={addMusic}>Add Movie</button>
    </div>
  )
}
export default App;
import './App.css';
import { useState } from 'react';
import {BrowserRouter , Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom'; 

function Home(){return(<h1>홈</h1>)}


function App() {
  let [list, setList] = useState([{
    title : "공지사항2",
    wirter : "admin",
    content : "공지사항2입니다."
  },{
    title : "공지사항1",
    wirter : "admin",
    content : "공지사항1입니다."
  }]);
  return(
    <BrowserRouter>
      <ul className="menu-list">
        <li><Link to="/">메인</Link></li>
        <li><Link to="/post/list">게시글 리스트</Link></li>
        <li><Link to="/post/insert">게시글 작성</Link></li>
      </ul>
      <Routes>
        <Route path="/" exact element={<Home/>} />
        <Route path="/post/list" element={<List list={list} 
                                          remove={remove} 
                                          add={addPost}/>} />
        <Route path="/post/insert" element={<Insert/>} />
      </Routes>
    </BrowserRouter>
  );
  function addPost(post){
    setList([post, ...list]);
  }

  function remove(index){
    let tmpList = [...list];
    tmpList.splice(index, 1);
    setList(tmpList);
  }

}

function List({list, add, remove}){
  //다른 페이지에서 전송한 정보를 받기 위해 location을 이용
  const location = useLocation();
  //누군가가 전송을 하면 location.state에 전송한 정보들이 담겨있다.
  let post = location.state;
  if(post != null){
    add(post);
    //처리 했으면 전송된 정보를 비움
    location.state = null;
  }
    return(
      <table>
        <thead>
          <tr>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
          </tr>
        </thead>	
        <tbody>
          {
            list.map((item, index)=>{
              return(
                <tr>
                  <td>{item.title}</td>
                  <td>{item.content}</td>
                  <td>{item.wirter}<button onClick={()=>remove(index)}>&times;</button></td>
                </tr>
              );
            })
          }
          
        </tbody>	
      </table>
    );
  }
  function Insert(){
    let [title, setTitle] = useState("");
    let [wirter, setWirter] = useState("");
    let [content, setContent] = useState("");
    
    //다른 페이지로 정보를 전송하기 위해서 navigate 사용
    const navigate = useNavigate();
    function insertPost(){
      //첫번쨰 매개변수 : 보낼 url
      //state : 상태정보, 
      navigate("/post/list",{
        state : {
          title,
          wirter,
          content
        }
      })
    }
    return(
      <div>
        <input placeholder="제목" type="text" onChange={(e) => setTitle(e.target.value)}/>
        <br/>
        <input placeholder="작성자" type="text" onChange={(e) => setWirter(e.target.value)}/>
        <br/>
        <textarea placeholder="내용" onChange={(e) => setContent(e.target.value)}></textarea>	
        <br/>
        <button onClick={insertPost}>게시글 등록</button>
      </div>
    );

    
  }

export default App;//내보낸다는 뜻 그래야 다른 폴더에서 해당 함수를 불러올 수 있음



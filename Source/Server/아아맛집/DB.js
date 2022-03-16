const MySql=require('sync-mysql');

//데이터베이스 연결부
const connection = new MySql({
    host: 'localhost',
    user: 'root',
    password: 'pstr8771',
    database:'Cafe'
  });

  // exports는 외부 파일에서 접근할 수 있는 함수같은 개념

  exports.Login=function(ID, password, token){
    const query=`select ID, Manager from Users
    where ID='${ID}'
    and Password='${password}'`;

    //로그인 데이터는 하나만
    const result=connection.query(query);
    console.log(result[0]);

    if(result[0]) {
      UpdateToken(ID, token);
    }

    return result[0];
  }


//회원가입
  exports.Register=function(ID, password, email){
    const query =`insert into users(ID, Password, Email, Manager) values('${ID}','${password}','${email}',2)`;
    connection.query(query);
  }


//주문내역 조회
  exports.GetOrder=function() {
    //주문내역을 조회하는 쿼리
    const orderQuery=`select O.* from Orders O
    join Users 
    on O.UserID=Users.ID`;

    const result=connection.query(orderQuery);
    return result;
  }

  //주문저장
  exports.InsertOrder=function(userID, content, price) {
    const query=`insert into orders(UserID, Contents, Price, status) values('${userID}', '${content}', ${price}, 0)`;
    connection.query(query);
  }

  //주문완료
  exports.UpdateStatus=function(OrderID) {
    const query=`update orders set status=1 where orderID=${OrderID}`;
    connection.query(query);

    const IDQuery=`select UserID from orders where orderID='${OrderID}'`;
    const UserID=connection.query(IDQuery)[0].UserID;
    const tokenQuery=`select token from users where ID='${UserID}'`;
    const token=connection.query(tokenQuery)[0].token;

    const fcm=require('./FCM');
    fcm.SendMessage(token);
  }
  
  //토큰 업데이트
function UpdateToken(userID, token) {
  const query=`update users set token='${token}' where ID='${userID}'`;
  connection.query(query);
}

//자신의 주문내역 조회
exports.GetMyOrders=function(UserID) {
  const query=`select * from orders where userID='${UserID}'`;
  return connection.query(query);
}
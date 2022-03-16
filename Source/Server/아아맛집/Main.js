/*require: 외부 모듈 불러오기
    ./ 이 붙은건 자신이 만든 파일
    안붙은 건 npm으로 설치한 것
*/
const Express=require('express');
const body_parser=require('body-parser');
const app=Express();
const DB=require('./DB');

const resultOK= {
    Result:"Ok"
}

//Json형식으로 파싱 가능
app.use(body_parser.json());

//로그인
app.post('/Login', function(req, res){
    //파라미터 받아오기
    const id=req.body['ID'];
    const password=req.body['Password'];
    const token=req.body['Token'];

    console.log(req.body);

    //쿼리 실행
   const result=DB.Login(id, password, token);
   //json 형태로 서버에서 반환
   res.json(result);
});

//회원가입
app.post('/Register', function(req, res){
    const id=req.body['ID'];
    const password=req.body['Password'];
    const email=req.body['Email'];

    console.log(req.body);

    const result=DB.Register(id, password, email);
    res.json(result);
});


//주문내역 답장
app.get('/Orders', (req,res)=>{
    const result=DB.GetOrder();
    res.json(result);
});

app.post('/Order', (req, res)=> {
    const body=req.body;
    const orderList=body['Orders'];
    const userID=body['UserID'];
    console.log(userID);

    var price=0;
    var content='';
    
    for(var i=0; i<orderList.length; i++) {
        price+=orderList[i].price;
        console.log(orderList[i]);
        content+=orderList[i].menuItem.name+'(';
        if(!orderList[i].ice&&!orderList[i].shot&&!orderList[i].syrup) {
            content+='해당없음';
        } else {
            if(orderList[i].ice)
            content+='아이스, ';
            if(orderList[i].shot)
            content+='샷추가, ';
            if(orderList[i].syrup)
            content+='시럽 추가, ';
            content=content.substring(0, content.length-2);
        }
        content+="), ";
    }

    content=content.substring(0, content.length-2);

    DB.InsertOrder(userID, content, price);
res.json(resultOK);
});

//완료
app.get('/Update/Status', (req, res)=> {
    const OrderID=req.query.OrderID;
    DB.UpdateStatus(OrderID);
    res.json(resultOK);
});

app.get('/Orders/My', (req, res)=> {
    const userID=req.query.UserID;
    res.json(DB.GetMyOrders(userID));
});


app.listen(9993, function() {
    console.log('서버 실행 중');
});


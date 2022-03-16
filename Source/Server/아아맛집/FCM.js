var FCM=require('fcm-node');

//안드로이드에게 운행정보 notification 전송
exports.SendMessage=function(tokken){
    var serverKey='AAAARWisbPc:APA91bH47W4j8pR6Ph15J7m-KIZOHfStxkYrRdUATQjY60pjtKF39qj2BZ4oM6vP43fJF_6HkVWWEj_9PZzv1HMt9v7-H_oFcHoBcfo938HlxgakDOIB2PTDxAErKDlxI71rb1wlGrnM';
    var fcm=new FCM(serverKey);
    if(tokken){
    var push_data={
        to:tokken,
        
        notification:{
            title: '제조 완료',
            body: '음료 나왔습니다.',
            sound:'default'
        },
    
        priority: 'high',
        restricted_package_name: 'kr.ac.gachon.Project201533745',
        data: {
            
        }
    };   
    fcm.send(push_data, function(err, response){
        if(err){
            console.log('메세지 발송 실패');
            console.error(err);
        } else{
            console.log('메시지 발송 성공');
        }
    });
}else {
  
}
}
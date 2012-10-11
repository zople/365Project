/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
                     var speed=30 //值越大速度越慢
                     var tab =document.getElementById("main_text");
                     var tab1=document.getElementById("main_text1");
                     var tab2=document.getElementById("main_text2");
                     tab2.innerHTML=tab1.innerHTML //克隆tab1为tab2

                     function Marquee(){
                     //向上滚动
                     if(tab2.offsetTop-tab.scrollTop<=0) //当滚动至tab1与tab2交界时
                     tab.scrollTop-=tab1.offsetHeight //tab跳到最顶端
                     else{
                     tab.scrollTop++
                     }

                     }
                     var MyMar=setInterval(Marquee,speed)//设置定时器
                     //鼠标移上时清除定时器达到滚动停止的目的
                     tab.onmouseover=function() {clearInterval(MyMar);                         
                     }
                     //鼠标移开时重设定时器
                     tab.onmouseout=function(){MyMar=setInterval(Marquee,speed)}


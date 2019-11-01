<template>
    <div class="printout">
        <div class="printdiv">
            
        </div>
    </div>
</template>
<script>
import {baseImgPath} from '@/config/env.js'
export default {
    name: 'Printer',
    data() {
        return {
            
        }
    },
    computed:{
        common(){
        return JSON.parse(localStorage.getItem('common'));
        },
        logoUrl(){
        return baseImgPath + "?path=" + encodeURIComponent(this.common.logo)
        },
        avatorUrl(){
        return baseImgPath + "?path=" + encodeURIComponent(this.common.avator)
        }
    },
}
</script>
<style>
    .printout{
        width: 1896px;
        height: 3469px;
        /* background: #ff0; */
        margin: auto;
    }
    .printdiv{
        width: 1035.81px;
        height: 645.68px;
        border-radius: 67.86px;
        border: 1px solid;
        background-color: red;
        margin-left: 94px;
        margin-top: 100px;
        /* background: url(/static/61584c26d4612265f389d09be1e1e2d.jpg) center center no-repeat; */
        background-size:55%;
        /* transform:rotate(90deg); */
    }
    .left{
        float: left;
        width: 399.99px;
        height: 100%;
        /* background:orange; */
        border-radius: 67.86px;
    }
    .right{
        float: right;
        width: 597.81px;
        height: 100%;
        /* background: #f0f; */
        border-radius: 67.86px;
    }

    .left img{
        margin-top: 57px;
        margin-left:94px;
        width: 211.99px;
        height: 270px;
    }
    .right img{
        width: 254px;
        height: 75px;
        margin-top:76px;
        margin-bottom:95px;
    }
    .right .detail{
        margin-top:40px;
        font-size: 30px;
        font-family: 微软雅黑;
    }
    .name{
        margin-top: 61px;
        margin-bottom: 61px;
        text-align: center;
        font-size: 48px;
        font-family: 微软雅黑;
    }
    .type{
        width: 299.37px;
        height: 79.84px;
        line-height: 79.84px;
        margin: auto;
        text-align: center;
        font-size: 36px;
        font-family: 微软雅黑;
        color: #fff;
        background: #38BECC;
        border-radius: 9.98px;
    }
    .small{
        margin-top:16px;
        font-size: 18px;
    }
</style>


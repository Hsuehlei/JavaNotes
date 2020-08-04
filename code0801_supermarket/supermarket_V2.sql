INSERT INTO t_order_detail(orderid,buyid,buycount) VALUES (6,6,6)
DELETE FROM t_order_detail WHERE id = 7
UPDATE t_order_detail SET buycount = 22 WHERE id = 6
SELECT bycount FROM t_order_detail WHERE id = 5
SELECT buycount FROM t_order_detail
select @@tx_isolation

INSERT INTO t_order_info(userid,ordertotalprice,ordertime,paymenttype) VALUES(6,55,NOW(),1)
DELETE FROM t_order_info WHERE id = 4

INSERT INTO t_goods_type(fatherid,typename,iffathertype,createtime) VALUE ()
UPDATE t_goods_type SET fatherid=2,typename='本地蔬菜',iffathertype=0,updatetime=NOW() WHERE typeid=5
SELECT * FROM t_goods_type WHERE typeid = 5
SELECT * FROM t_goods_type

INSERT INTO t_goods_info(goodsname,goodstype,goodscount,unitprice,goodsstatus,discount,createtime) VALUES ('橘子',1,300,1.5,1,7.5,NOW())
DELETE FROM t_goods_info WHERE id = 
UPDATE t_goods_info SET goodscount = 500,unitprice = 1.3,goodsstatus = 1,discount = 9,updatetime = NOW() WHERE goodsid = 6
SELECT * FROM t_goods_info WHERE goodsid = 6

INSERT INTO t_vip_info(vipname,vippassword,tel,integral,balance,createtime) VALUES ('吴八','123456','13345678912',30,55.5,NOW())
DELETE FROM t_vip_info WHERE vipid = 
UPDATE t_vip_info SET vipname = ?,vippassword = ?,tel = ?, integral = ?, balance = ?, updatetime = NOW() WHERE vipid = ?
SELECT * FROM t_vip_info WHERE vipid = 
SELECT balance FROM t_vip_info WHERE vipid = 6
UPDATE t_vip_info SET balance = 100 WHERE vipid = 6
SELECT balance FROM t_vip_info WHERE vipid = 5

UPDATE t_goods_info SET goodscount = 500, updatetime = NOW() WHERE goodsid = 1
INSERT INTO t_order_info(userid, ordertotalprice, ordertime, paymenttype) VALUES (?, ?, NOW(), 0)
INSERT INTO t_order_detail(orderid, buyid, buycount) VALUES (?, ?, ?) 
UPDATE t_vip_info SET balance = ? WHERE vipid = ?

SET @@global.sql_mode= ‘’;

SELECT * FROM t_order_detail WHERE buyid = 1
SELECT t.orderid,userid,ordertotalprice,ordertime,paymenttype FROM t_order_detail t,t_order_info WHERE buyid = 1 AND t.orderid = t_order_info.orderid

SELECT * FROM t_order_info WHERE userid = 7
SELECT id,t.orderid,buyid,buycount FROM t_order_info t,t_order_detail WHERE userid = 7 AND t.orderid = t_order_detail.orderid

SELECT t1.goodsid,t1.goodsname,sum(t2.buycount) FROM t_goods_info t1,t_order_detail t2,t_order_info t3 
WHERE t2.orderid = t3.orderid AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') >= DATE_FORMAT('2020-07-01','%Y-%m-%d') 
AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') <= DATE_FORMAT('2020-08-01','%Y-%m-%d')  
AND t1.goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) AND t1.goodsid = t2.buyid 
GROUP BY t1.goodsid ORDER BY SUM(t2.buycount) DESC LIMIT 0,10


SELECT buyid,COUNT(buyid) FROM t_order_detail GROUP BY buyid

select t.* from A t where date_format(t.a,'%Y-%m')='2011-02';

SELECT goodsid,goodsname,sum(buycount) 
FROM t_goods_info,t_order_detail,t_order_info t 
WHERE DATE_FORMAT(t.ordertime,'%Y-%m-%d') >= DATE_FORMAT('2020-07-31','%Y-%m-%d') 
AND DATE_FORMAT(t.ordertime,'%Y-%m-%d') <= DATE_FORMAT('2020-08-01','%Y-%m-%d')  
AND goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) 
AND goodsid = buyid 
GROUP BY goodsid 
ORDER BY SUM(buycount) DESC LIMIT 0,10

-- 
SELECT t1.goodsid,t1.goodsname,sum(t2.buycount) 
FROM t_goods_info t1,t_order_detail t2,t_order_info t3 
WHERE t1.goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) 
AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') >= DATE_FORMAT('2020-07-31','%Y-%m-%d') 
AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') <= DATE_FORMAT('2020-08-01','%Y-%m-%d')  
AND t1.goodsid = t2.buyid 
GROUP BY goodsid 
ORDER BY SUM(buycount) DESC 
LIMIT 0,10

SELECT t1.goodsid,t1.goodsname,sum(t2.buycount) 
FROM t_goods_info t1,t_order_detail t2,t_order_info t3 
WHERE t2.orderid = t3.orderid 
AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') >= DATE_FORMAT('2020-07-01','%Y-%m-%d') 
AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') <= DATE_FORMAT('2020-08-05','%Y-%m-%d') 
AND t1.goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) 
AND t1.goodsid = t2.buyid 
GROUP BY t1.goodsid 
ORDER BY SUM(t2.buycount) DESC 
LIMIT 0,10

SELECT * FROM USER
SHOW GRANTS FOR	'root'@'localhost'

select * from t_vip_info where vipname = '张三' and vippassword = 123456

(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[9],{"A0/X":function(e,t,a){"use strict";var r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var u=r(a("mK77")),n=r(a("Ico4")),l=a("vrWy"),c={namespace:"listTableList",state:{data:{list:[],pagination:{}}},effects:{fetch:n.default.mark(function e(t,a){var r,u,c,s;return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,u=a.call,c=a.put,e.next=4,u(l.queryRule,r);case 4:return s=e.sent,e.next=7,c({type:"save",payload:s});case 7:case"end":return e.stop()}},e)}),add:n.default.mark(function e(t,a){var r,u,c,s,p;return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,u=t.callback,c=a.call,s=a.put,e.next=4,c(l.addRule,r);case 4:return p=e.sent,e.next=7,s({type:"save",payload:p});case 7:u&&u();case 8:case"end":return e.stop()}},e)}),remove:n.default.mark(function e(t,a){var r,u,c,s,p;return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,u=t.callback,c=a.call,s=a.put,e.next=4,c(l.removeRule,r);case 4:return p=e.sent,e.next=7,s({type:"save",payload:p});case 7:u&&u();case 8:case"end":return e.stop()}},e)}),update:n.default.mark(function e(t,a){var r,u,c,s,p;return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,u=t.callback,c=a.call,s=a.put,e.next=4,c(l.updateRule,r);case 4:return p=e.sent,e.next=7,s({type:"save",payload:p});case 7:u&&u();case 8:case"end":return e.stop()}},e)})},reducers:{save:function(e,t){return(0,u.default)({},e,{data:t.payload})}}},s=c;t.default=s},vrWy:function(e,t,a){"use strict";var r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.queryRule=s,t.removeRule=d,t.addRule=o,t.updateRule=h;var u=r(a("mK77")),n=r(a("Ico4")),l=r(a("UWy3")),c=r(a("uubZ"));function s(e){return p.apply(this,arguments)}function p(){return p=(0,l.default)(n.default.mark(function e(t){return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,c.default)("/api/rule",{params:t}));case 1:case"end":return e.stop()}},e)})),p.apply(this,arguments)}function d(e){return i.apply(this,arguments)}function i(){return i=(0,l.default)(n.default.mark(function e(t){return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,c.default)("/api/rule",{method:"POST",data:(0,u.default)({},t,{method:"delete"})}));case 1:case"end":return e.stop()}},e)})),i.apply(this,arguments)}function o(e){return f.apply(this,arguments)}function f(){return f=(0,l.default)(n.default.mark(function e(t){return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,c.default)("/api/rule",{method:"POST",data:(0,u.default)({},t,{method:"post"})}));case 1:case"end":return e.stop()}},e)})),f.apply(this,arguments)}function h(e){return w.apply(this,arguments)}function w(){return w=(0,l.default)(n.default.mark(function e(t){return n.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,c.default)("/api/rule",{method:"POST",data:(0,u.default)({},t,{method:"update"})}));case 1:case"end":return e.stop()}},e)})),w.apply(this,arguments)}}}]);
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[10],{"336r":function(e,t,a){e.exports={login:"antd-pro-pages-user-login-components-login-index-login",getCaptcha:"antd-pro-pages-user-login-components-login-index-getCaptcha",icon:"antd-pro-pages-user-login-components-login-index-icon",other:"antd-pro-pages-user-login-components-login-index-other",register:"antd-pro-pages-user-login-components-login-index-register",prefixIcon:"antd-pro-pages-user-login-components-login-index-prefixIcon",submit:"antd-pro-pages-user-login-components-login-index-submit"}},"3T1H":function(e,t,a){"use strict";var n=a("fbTi"),r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("WYSL");var o=r(a("n4pQ"));a("GOcw");var l=r(a("W9U2"));a("k1Ox");var u=r(a("DVMa")),i=r(a("mK77")),s=r(a("43Yg")),d=r(a("/tCh")),c=r(a("scpF")),f=r(a("O/V9")),p=r(a("8aBX")),m=a("GMBo"),g=n(a("uqIC")),h=r(a("WBkv")),v=a("LneV"),b=r(a("U2lG")),y=r(a("d40l")),C=function(e,t,a,n){var r,o=arguments.length,l=o<3?t:null===n?n=Object.getOwnPropertyDescriptor(t,a):n;if("object"===typeof Reflect&&"function"===typeof Reflect.decorate)l=Reflect.decorate(e,t,a,n);else for(var u=e.length-1;u>=0;u--)(r=e[u])&&(l=(o<3?r(l):o>3?r(t,a,l):r(t,a))||l);return o>3&&l&&Object.defineProperty(t,a,l),l},E=b.default.Tab,M=b.default.UserName,x=b.default.Password,T=b.default.Mobile,w=b.default.Captcha,q=b.default.Submit,N=function(e){function t(){var e;return(0,s.default)(this,t),e=(0,c.default)(this,(0,f.default)(t).apply(this,arguments)),e.loginForm=void 0,e.state={type:"account",autoLogin:!0},e.changeAutoLogin=function(t){e.setState({autoLogin:t.target.checked})},e.handleSubmit=function(t,a){var n=e.state.type;if(!t){var r=e.props.dispatch;r({type:"userLogin/login",payload:(0,i.default)({},a,{type:n})})}},e.onTabChange=function(t){e.setState({type:t})},e.onGetCaptcha=function(){return new Promise(function(t,a){e.loginForm&&e.loginForm.validateFields(["mobile"],{},function(n,r){if(n)a(n);else{var o=e.props.dispatch;o({type:"userLogin/getCaptcha",payload:r.mobile}).then(t).catch(a)}})})},e.renderMessage=function(e){return g.default.createElement(u.default,{style:{marginBottom:24},message:e,type:"error",showIcon:!0})},e}return(0,p.default)(t,e),(0,d.default)(t,[{key:"render",value:function(){var e=this,t=this.props,a=t.userLogin,n=t.submitting,r=a.status,u=a.type,i=this.state,s=i.type,d=i.autoLogin;return g.default.createElement("div",{className:y.default.main},g.default.createElement(b.default,{defaultActiveKey:s,onTabChange:this.onTabChange,onSubmit:this.handleSubmit,ref:function(t){e.loginForm=t}},g.default.createElement(E,{key:"account",tab:(0,m.formatMessage)({id:"user-login.login.tab-login-credentials"})},"error"===r&&"account"===u&&!n&&this.renderMessage((0,m.formatMessage)({id:"user-login.login.message-invalid-credentials"})),g.default.createElement(M,{name:"userName",placeholder:"".concat((0,m.formatMessage)({id:"user-login.login.userName"}),": admin or user"),rules:[{required:!0,message:(0,m.formatMessage)({id:"user-login.userName.required"})}]}),g.default.createElement(x,{name:"password",placeholder:"".concat((0,m.formatMessage)({id:"user-login.login.password"}),": ant.design"),rules:[{required:!0,message:(0,m.formatMessage)({id:"user-login.password.required"})}],onPressEnter:function(t){t.preventDefault(),e.loginForm&&e.loginForm.validateFields(e.handleSubmit)}})),g.default.createElement(E,{key:"mobile",tab:(0,m.formatMessage)({id:"user-login.login.tab-login-mobile"})},"error"===r&&"mobile"===u&&!n&&this.renderMessage((0,m.formatMessage)({id:"user-login.login.message-invalid-verification-code"})),g.default.createElement(T,{name:"mobile",placeholder:(0,m.formatMessage)({id:"user-login.phone-number.placeholder"}),rules:[{required:!0,message:(0,m.formatMessage)({id:"user-login.phone-number.required"})},{pattern:/^1\d{10}$/,message:(0,m.formatMessage)({id:"user-login.phone-number.wrong-format"})}]}),g.default.createElement(w,{name:"captcha",placeholder:(0,m.formatMessage)({id:"user-login.verification-code.placeholder"}),countDown:120,onGetCaptcha:this.onGetCaptcha,getCaptchaButtonText:(0,m.formatMessage)({id:"user-login.form.get-captcha"}),getCaptchaSecondText:(0,m.formatMessage)({id:"user-login.captcha.second"}),rules:[{required:!0,message:(0,m.formatMessage)({id:"user-login.verification-code.required"})}]})),g.default.createElement("div",null,g.default.createElement(l.default,{checked:d,onChange:this.changeAutoLogin},g.default.createElement(m.FormattedMessage,{id:"user-login.login.remember-me"})),g.default.createElement("a",{style:{float:"right"},href:""},g.default.createElement(m.FormattedMessage,{id:"user-login.login.forgot-password"}))),g.default.createElement(q,{loading:n},g.default.createElement(m.FormattedMessage,{id:"user-login.login.login"})),g.default.createElement("div",{className:y.default.other},g.default.createElement(m.FormattedMessage,{id:"user-login.login.sign-in-with"}),g.default.createElement(o.default,{type:"alipay-circle",className:y.default.icon,theme:"outlined"}),g.default.createElement(o.default,{type:"taobao-circle",className:y.default.icon,theme:"outlined"}),g.default.createElement(o.default,{type:"weibo-circle",className:y.default.icon,theme:"outlined"}),g.default.createElement(h.default,{className:y.default.register,to:"/user/register"},g.default.createElement(m.FormattedMessage,{id:"user-login.login.signup"})))))}}]),t}(g.Component);N=C([(0,v.connect)(function(e){var t=e.userLogin,a=e.loading;return{userLogin:t,submitting:a.effects["userLogin/login"]}})],N);var S=N;t.default=S},D4xa:function(e,t,a){"use strict";var n=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("WYSL");var r=n(a("n4pQ")),o=n(a("uqIC")),l=n(a("336r")),u={UserName:{props:{size:"large",id:"userName",prefix:o.default.createElement(r.default,{type:"user",className:l.default.prefixIcon}),placeholder:"admin"},rules:[{required:!0,message:"Please enter username!"}]},Password:{props:{size:"large",prefix:o.default.createElement(r.default,{type:"lock",className:l.default.prefixIcon}),type:"password",id:"password",placeholder:"888888"},rules:[{required:!0,message:"Please enter password!"}]},Mobile:{props:{size:"large",prefix:o.default.createElement(r.default,{type:"mobile",className:l.default.prefixIcon}),placeholder:"mobile number"},rules:[{required:!0,message:"Please enter mobile number!"},{pattern:/^1\d{10}$/,message:"Wrong mobile number format!"}]},Captcha:{props:{size:"large",prefix:o.default.createElement(r.default,{type:"mail",className:l.default.prefixIcon}),placeholder:"captcha"},rules:[{required:!0,message:"Please enter Captcha!"}]}};t.default=u},KTBR:function(e,t,a){"use strict";var n=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("jxze");var r=n(a("baKk")),o=n(a("BG4o"));a("jqTM");var l=n(a("n0rf")),u=n(a("uqIC")),i=n(a("iczh")),s=n(a("336r")),d=l.default.Item,c=function(e){var t=e.className,a=(0,o.default)(e,["className"]),n=(0,i.default)(s.default.submit,t);return u.default.createElement(d,null,u.default.createElement(r.default,Object.assign({size:"large",className:n,type:"primary",htmlType:"submit"},a)))},f=c;t.default=f},U2lG:function(e,t,a){"use strict";var n=a("fbTi"),r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("h0fJ");var o=r(a("qFIA"));a("jqTM");var l=r(a("n0rf")),u=r(a("mK77")),i=r(a("rXjv")),s=r(a("43Yg")),d=r(a("/tCh")),c=r(a("scpF")),f=r(a("O/V9")),p=r(a("8aBX")),m=n(a("uqIC")),g=r(a("iczh")),h=r(a("booR")),v=r(a("ana9")),b=r(a("KTBR")),y=r(a("aGQT")),C=r(a("336r")),E=function(e){function t(e){var a;return(0,s.default)(this,t),a=(0,c.default)(this,(0,f.default)(t).call(this,e)),a.onSwitch=function(e){a.setState({type:e},function(){var t=a.props.onTabChange;t&&t(e)})},a.getContext=function(){var e=a.props.form,t=a.state.tabs,n=void 0===t?[]:t;return{tabUtil:{addTab:function(e){a.setState({tabs:[].concat((0,i.default)(n),[e])})},removeTab:function(e){a.setState({tabs:n.filter(function(t){return t!==e})})}},form:(0,u.default)({},e),updateActive:function(e){var t=a.state,n=t.type,r=void 0===n?"":n,o=t.active,l=void 0===o?{}:o;l[r]?l[r].push(e):l[r]=[e],a.setState({active:l})}}},a.handleSubmit=function(e){e.preventDefault();var t=a.state,n=t.active,r=void 0===n?{}:n,o=t.type,l=void 0===o?"":o,u=a.props,i=u.form,s=u.onSubmit,d=r[l]||[];i&&i.validateFields(d,{force:!0},function(e,t){s&&s(e,t)})},a.state={type:e.defaultActiveKey,tabs:[],active:{}},a}return(0,p.default)(t,e),(0,d.default)(t,[{key:"render",value:function(){var e=this.props,t=e.className,a=e.children,n=this.state,r=n.type,u=n.tabs,i=void 0===u?[]:u,s=[],d=[];return m.default.Children.forEach(a,function(e){e&&("LoginTab"===e.type.typeName?s.push(e):d.push(e))}),m.default.createElement(h.default.Provider,{value:this.getContext()},m.default.createElement("div",{className:(0,g.default)(t,C.default.login)},m.default.createElement(l.default,{onSubmit:this.handleSubmit},i.length?m.default.createElement(m.default.Fragment,null,m.default.createElement(o.default,{animated:!1,className:C.default.tabs,activeKey:r,onChange:this.onSwitch},s),d):a)))}}]),t}(m.Component);E.Tab=y.default,E.Submit=b.default,E.defaultProps={className:"",defaultActiveKey:"",onTabChange:function(){},onSubmit:function(){}},Object.keys(v.default).forEach(function(e){E[e]=v.default[e]});var M=l.default.create()(E);t.default=M},aGQT:function(e,t,a){"use strict";var n=a("fbTi"),r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var o=r(a("43Yg")),l=r(a("/tCh")),u=r(a("scpF")),i=r(a("O/V9")),s=r(a("8aBX"));a("h0fJ");var d=r(a("qFIA")),c=n(a("uqIC")),f=r(a("booR")),p=d.default.TabPane,m=function(){var e=0;return function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"";return e+=1,"".concat(t).concat(e)}}(),g=function(e){function t(e){var a;return(0,o.default)(this,t),a=(0,u.default)(this,(0,i.default)(t).call(this,e)),a.uniqueId="",a.uniqueId=m("login-tab-"),a}return(0,s.default)(t,e),(0,l.default)(t,[{key:"componentDidMount",value:function(){var e=this.props.tabUtil;e&&e.addTab(this.uniqueId)}},{key:"render",value:function(){var e=this.props.children;return c.default.createElement(p,Object.assign({},this.props),e)}}]),t}(c.Component),h=function(e){return c.default.createElement(f.default.Consumer,null,function(t){return c.default.createElement(g,Object.assign({tabUtil:t.tabUtil},e))})};h.typeName="LoginTab";var v=h;t.default=v},ana9:function(e,t,a){"use strict";var n=a("fbTi"),r=a("mZ4U");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("jxze");var o=r(a("baKk"));a("f4gl");var l=r(a("GHNm"));a("aHlT");var u=r(a("hhxt"));a("dspT");var i=r(a("VYVj")),s=r(a("BG4o")),d=r(a("43Yg")),c=r(a("/tCh")),f=r(a("scpF")),p=r(a("O/V9")),m=r(a("8aBX"));a("jqTM");var g=r(a("n0rf")),h=n(a("uqIC")),v=r(a("B1rl")),b=r(a("D4xa")),y=r(a("booR")),C=r(a("336r")),E=g.default.Item,M=function(e){function t(e){var a;return(0,d.default)(this,t),a=(0,f.default)(this,(0,p.default)(t).call(this,e)),a.interval=void 0,a.onGetCaptcha=function(){var e=a.props.onGetCaptcha,t=e?e():null;!1!==t&&(t instanceof Promise?t.then(a.runGetCaptchaCountDown):a.runGetCaptchaCountDown())},a.getFormItemOptions=function(e){var t=e.onChange,a=e.defaultValue,n=e.customProps,r=void 0===n?{}:n,o=e.rules,l={rules:o||r.rules};return t&&(l.onChange=t),a&&(l.initialValue=a),l},a.runGetCaptchaCountDown=function(){var e=a.props.countDown,t=e||59;a.setState({count:t}),a.interval=window.setInterval(function(){t-=1,a.setState({count:t}),0===t&&clearInterval(a.interval)},1e3)},a.state={count:0},a}return(0,m.default)(t,e),(0,c.default)(t,[{key:"componentDidMount",value:function(){var e=this.props,t=e.updateActive,a=e.name,n=void 0===a?"":a;t&&t(n)}},{key:"componentWillUnmount",value:function(){clearInterval(this.interval)}},{key:"render",value:function(){var e=this.state.count,t=this.props,a=(t.onChange,t.customProps),n=(t.defaultValue,t.rules,t.name),r=t.getCaptchaButtonText,d=t.getCaptchaSecondText,c=(t.updateActive,t.type),f=t.form,p=(t.tabUtil,(0,s.default)(t,["onChange","customProps","defaultValue","rules","name","getCaptchaButtonText","getCaptchaSecondText","updateActive","type","form","tabUtil"]));if(!n)return null;if(!f)return null;var m=f.getFieldDecorator,g=this.getFormItemOptions(this.props),b=p||{};if("Captcha"===c){var y=(0,v.default)(b,["onGetCaptcha","countDown"]);return h.default.createElement(E,null,h.default.createElement(i.default,{gutter:8},h.default.createElement(u.default,{span:16},m(n,g)(h.default.createElement(l.default,Object.assign({},a,y)))),h.default.createElement(u.default,{span:8},h.default.createElement(o.default,{disabled:!!e,className:C.default.getCaptcha,size:"large",onClick:this.onGetCaptcha},e?"".concat(e," ").concat(d):r))))}return h.default.createElement(E,null,m(n,g)(h.default.createElement(l.default,Object.assign({},a,b))))}}]),t}(h.Component);M.defaultProps={getCaptchaButtonText:"captcha",getCaptchaSecondText:"second"};var x={};Object.keys(b.default).forEach(function(e){var t=b.default[e];x[e]=function(a){return h.default.createElement(y.default.Consumer,null,function(n){return h.default.createElement(M,Object.assign({customProps:t.props,rules:t.rules},a,{type:e},n,{updateActive:n.updateActive}))})}});var T=x;t.default=T},booR:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var n=a("uqIC"),r=(0,n.createContext)({}),o=r;t.default=o},d40l:function(e,t,a){e.exports={main:"antd-pro-pages-user-login-style-main",icon:"antd-pro-pages-user-login-style-icon",other:"antd-pro-pages-user-login-style-other",register:"antd-pro-pages-user-login-style-register"}}}]);
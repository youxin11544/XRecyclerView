# XRecyclerView
RecyclerView  下拉刷新，上拉加载

 *     这里做的是一种思想。 我一直强调思想很重要。呵呵，欢迎大牛有更好的思想的人吐槽。
 *
 *   这里 刷新的框架用的是 https://github.com/OrangeGangsters/SwipyRefreshLayout
 *   这里 RecyclerView的adaper封装是借用 鸿翔的 ： https://github.com/hongyangAndroid/baseAdapter  这个封装的很好的
 *   不管用谁的框架，我们要学习思想，才是关键，这里写的 XRecyclerView ，是我日常才用列表的总结。学会后，以后不管谁的框架，拿过来分分钟就把它封装了，耶！


 *   这里将  列表的 页面数 以及 状态 全部封装在 XRecyclerView 中，这样 XRecyclerView 遵从类的单一原则， 同时 以后的Activity的代码将会减少很多。不需要关心多少页了，关于列表的东西全部交给 XRecyclerView 他全部处理，有事找他。我们还可以继续扩展。同时Activity 字需要写发送请求代码，拿到数据只需要更新填充列表和重新填充列表，这个demo字需要关注XRecyclerView 这个类就可了。
 

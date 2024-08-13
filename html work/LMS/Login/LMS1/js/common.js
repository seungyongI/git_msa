$(document).ready(function () {
    $(".lnb_list > ul").on("click", "li", function(e){
        if ($(e.target).is('.lnb_cont a')) {
            // 하위 메뉴의 a 태그 클릭 시 기본 동작 수행
            return;
        }

        e.preventDefault(); // 상위 메뉴의 a 태그 클릭 시 기본 동작 방지

        if($(this).hasClass("active") == false){
            $(".lnb_list > ul > li").removeClass("active");
            $(this).addClass("active");
            $(".lnb_list ul ul").slideUp(300);
            $(this).children("ul").slideDown(300);
        }
        else{
            $(this).removeClass("active");
            $(this).children("ul").slideUp(300);
        }
    });
});
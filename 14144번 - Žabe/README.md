# 14144번: Žabe - <img src="https://static.solved.ac/tier_small/17.svg" style="height:20px" /> Platinum IV

<!-- performance -->

<!-- 문제 제출 후 깃허브에 푸시를 했을 때 제출한 코드의 성능이 입력될 공간입니다.-->

<!-- end -->

## 문제

[문제 링크](https://boj.kr/14144)

<p>Na jednom jezeru nalazi se beskonačan niz lopoča, pravilno poredanih jedan do drugog u ravnoj liniji, na kojima se svakodnevno odmaraju žabe. Svako jutro žabe se poredaju po lopočima prema sljedećim pravilima:</p>

<ul>
<li>Postoji N tipova žaba, tipovi su označeni redom brojevima od 1 do N, te je, za svaki tip, poznato koliko ukupno žaba tog tipa obitava na jezeru.</li>
<li>Žaba tipa d uvijek skače udaljenost u iznosu od d lopoča, a svaka žaba skače sve dok ne stigne do lopoča na kojem nema druge žabe, te se tamo zadrži do kraja dana.</li>
<li>Na jezeru žabe dolaze jedna po jedna, te skaču po gornjim pravilima dok se ne smjeste na lopoč. Najprije na red dolaze sve žabe tipa 1, zatim sve žabe tipa 2, i tako dalje do žaba tipa N.</li>
</ul>

<p>Slijedi ilustracija prvog primjera. Ukupno postoji tri tipa žaba, a na jezeru obitavaju po dvije žabe svakog tipa.</p>

<p>Nule predstavljaju prazne lopoče, a ostali brojevi tip žabe koja se zadržala na lopoču. Osjenčani su lopoči po kojima je zadnja žaba skakala dok se nije smjestila na svoj lopoč.&nbsp;</p>

<p><img alt="" src="https://onlinejudgeimages.s3.amazonaws.com/problem/14144/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202017-01-03%20%EC%98%A4%ED%9B%84%202.58.46.png" style="height:296px; width:317px"></p>

<p>Zadnja žaba tipa 1 nalazi se na poziciji 2, žaba tipa 2 na poziciji 6, a zadnja žaba tipa 3 na poziciji 9.</p>

<p>Napišite program koji će za svaki tip žabe odrediti poziciju najdaljeg lopoča na kojem se nalazi žaba tog tipa.&nbsp;</p>

## 입력

<p>U prvom retku nalazi se prirodan broj N (1 ≤ N ≤ 10), broj tipova žaba.</p>

<p>U svakom od sljedećih N redaka nalazi se po jedan prirodan broj manji ili jednak od 50 000 000, broj žaba odgovarajućeg tipa, redom od tipa 1 do tipa N.</p>

## 출력

<p>U N redaka treba ispisati po jedan prirodan broj, poziciju najdaljeg lopoča na kojem se nalazi žaba odreñenog tipa, redom od tipa 1 do tipa N.&nbsp;</p>

## 소스코드

[소스코드 보기](Main.java)
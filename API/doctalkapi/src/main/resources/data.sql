insert into user (email, password, user_status, created_date) values ( 'pleasure082@gmail.com', 'test1234', 'ACTIVE', CURRENT_TIMESTAMP() );

insert into doctor (name, created_date) values ('조용윤 의사', current_timestamp() );
insert into doctor (name, created_date) values ('김병주 한의사', current_timestamp() );

insert into question (title, content, source, user_id, created_date) values ( '다래끼는 왜 생기는 걸까요?', '<p>아시는 분있으시면 내공 20들릴게요!</p><p>요즘 다래끼가 생겨서요.</p>', null, 1, CURRENT_TIMESTAMP());;
insert into tag (name, created_date) values ('다래끼', CURRENT_TIMESTAMP());
insert into tag (name, created_date) values ('눈병', CURRENT_TIMESTAMP());
insert into question_tag (question_id, tag_id, created_date) values (1, 1, CURRENT_TIMESTAMP());
insert into question_tag (question_id, tag_id, created_date) values (1, 2, CURRENT_TIMESTAMP());

insert into question (title, content, source, user_id, created_date) values ( '하드렌즈 보관법', '<p>하드렌즈를 사용하지 않은 날에도 매일 세척액으로 세척하고 보관통에 넣어야되나요?</p>', null, 1, CURRENT_TIMESTAMP());
insert into tag (name, created_date) values ('렌즈', CURRENT_TIMESTAMP());
insert into question_tag (question_id, tag_id, created_date) values (2, 3, CURRENT_TIMESTAMP());

insert into question (title, content, source, user_id, created_date) values ( '어제 놀랬어요', '<p>퇴근길 제가 후방추돌 할뻔한걸 피한후<br /><br />심장이 5분동안 아주빠르게 뛰었어요<br /><br />태어나 크게 놀랜건 처음입니다.<br /><br />다음날인 오늘도 심장쪽이 흥분한 느낌이들어요<br /><br />어렸을때 놀라면 아버지가 바늘로 열손가락을 모두 따주셨어요<br />한의원가서 침맞아야되나요?</p>', null, 1, CURRENT_TIMESTAMP());
insert into tag (name, created_date) values ('침', CURRENT_TIMESTAMP());
insert into question_tag (question_id, tag_id, created_date) values (3, 4, CURRENT_TIMESTAMP());

insert into answer (content, doctor_id, question_id, created_date) values ('<p>안녕하세요. 닥톡-네이버 지식인 상담의사 조용윤입니다.</p><p>다래끼는 대부분 세균감염에 의해 발생하게 됩니다.</p><p>면역력이 약한 경우와 피로감이 있으면 균에 대한 저항력이 떨어져 발생합니다.</p><p>손으로 눈을 비비지 마셔야 하며, 눈 화장도 원인에 포함될 수 있습니다.</p><p>증상이 심하지 않으면 약물로도 호전이 가능하오니</p><p>안과에 내원하셔서 적절한 치료를 받으시기를 바랍니다.</p><p>감사합니다.</p>'
                                                                                ,1, 1, current_timestamp());
insert into answer (content, doctor_id, question_id, created_date) values ('<p>안녕하세요. 닥톡-네이버 지식iN 상담의사 조용윤 입니다.</p><p>하드렌즈의 경우 매일 착용하시 않으시더라도 2~3일에 한번씩은</p><p>보존액을 교체해주셔야합니다.</p><p>장기간 착용하지 않으신다면 렌즈를 깨끗하게 세척하신후</p><p>부드런운 천등으로 물기를 제거한다음 마른상태로 보관하셨다</p><p>착용하기 하루전에 보존액에 보관하셨다 착용하시는게 좋습니다.</p><p>보통 세척을 맡기는 경우는 단백질이 렌즈에 침착되어 세척이 되지 않을때</p><p>하시는게 좋습니다. 주기적으로 하는것도 좋지만 렌즈상태에 따라서</p><p>단백질세척을 맡기시는게 좋습니다.</p><p>감사합니다.</p>'
                                                                                ,1, 2, current_timestamp());
insert into answer (content, doctor_id, question_id, created_date) values ('<p>안녕하세요?</p><p>닥톡-네이버 지식iN 상담한의사 김병주입니다.</p><p>질문자님의 내용을 요약하면 아래와 같습니다.</p><br /><p>Q. 어제 후방 추돌을 피한 직후에 크게 놀랐고, 오늘도 흥분된 느낌이 들고 있어요. 한의원에서 침맞아야 되나요?</p><br /><p>A. 우선 차 사고가 나지 않으신 것 같아서 그나마 다행이시네요. 놀래서 발생한 증상은 한의원 치료를 받으면 도움이 됩니다.</p><br /><p>궁금해하시는 점에 도움이 되었기를 바랍니다. 감사합니다.</p>'
                                                                                ,2, 3, current_timestamp());







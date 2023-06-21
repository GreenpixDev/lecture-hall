create table public.ban
(
    group_id uuid         not null
        constraint fk_member_group
            references public.group,
    user_id  uuid         not null
        constraint fk_member_user
            references public.user,
    creation  timestamp(6) not null,
    primary key (group_id, user_id)
);
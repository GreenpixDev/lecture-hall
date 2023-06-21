create table public.user
(
    id           uuid         not null
        primary key,
    registration timestamp(6) not null,
    vk_id        integer      not null
        constraint uk_user_vk_id
            unique
);

create table public.group
(
    id       uuid         not null
        primary key,
    creation timestamp(6) not null,
    name     varchar(255),
    owner_id uuid         not null
        constraint fk_group_owner
            references public.user
);

create table public.invitation
(
    id          uuid         not null
        primary key,
    code        varchar(255) not null
        constraint uk_invitation_code
            unique,
    creation    timestamp(6) not null,
    expiration  timestamp(6),
    usage_limit integer,
    usages      integer      not null,
    group_id    uuid         not null
        constraint fk_invitation_group
            references public.group
);

create table public.member
(
    group_id uuid         not null
        constraint fk_member_group
            references public.group,
    user_id  uuid         not null
        constraint fk_member_user
            references public.user,
    admin    boolean      not null,
    joining  timestamp(6) not null,
    primary key (group_id, user_id)
);

create table public.subject
(
    id       uuid         not null
        primary key,
    creation timestamp(6) not null,
    name     varchar(255) not null
        constraint uk_subject_name
            unique,
    group_id uuid         not null
        constraint fk_subject_group
            references public.group
);

create table public.tag
(
    id       uuid         not null
        primary key,
    name     varchar(255) not null
        constraint uk_tag_name
            unique,
    group_id uuid         not null
        constraint fk_tag_group
            references public.group
);

create table public.label
(
    id         uuid         not null
        primary key,
    value      varchar(255) not null,
    key_tag_id uuid         not null
        constraint fk_label_key_tag
            references public.tag
);

create table public.video
(
    id          uuid         not null
        primary key,
    creation    timestamp(6) not null,
    description varchar(255),
    player_url  varchar(255),
    recording   timestamp(6) not null,
    title       varchar(255) not null,
    vk_id       integer      not null,
    group_id    uuid         not null
        constraint fk_video_group
            references public.group,
    subject_id  uuid         not null
        constraint fk_video_subject
            references public.subject
);

create table public.video_label
(
    video_id uuid not null
        constraint fk_video_label_video
            references public.video,
    label_id uuid not null
        constraint fk_video_label_label
            references public.label,
    primary key (video_id, label_id)
);
alter table public.subject
    drop constraint uk_subject_name;

alter table public.tag
    drop constraint uk_tag_name;

alter table public.subject
    add constraint uk_subject_group_name unique (group_id, name);

alter table public.tag
    add constraint uk_tag_group_name unique (group_id, name);

alter table public.label
    add constraint uk_label_key_value unique (key_tag_id, value);